package com.example.geomob_encyclopedie_geographique

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.geomob_encyclopedie_geographique.DataRoom.ImagePays
import com.example.geomob_encyclopedie_geographique.DataRoom.Pays
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel
import com.example.geomob_encyclopedie_geographique.DataRoom.VideoPays
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_country_info.*
import kotlinx.android.synthetic.main.fragment_images_videos_country_tab.*
import kotlinx.android.synthetic.main.fragment_info_country_tab.*


class CountryInfoActivity : AppCompatActivity() {

    private lateinit var paysViewModel: PaysViewModel

    private lateinit var nomPays : TextView

    lateinit var imageList:MutableList<ImagePays>

    //Slide Show
    internal lateinit var slideViewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)

        //get id of country
        val id_Pays = intent.getIntExtra("id_Pays",0)
        val FragmentAdapter = TabsAdapter(supportFragmentManager,id_Pays)
        viewPager.adapter = FragmentAdapter


        //Slideshow
        slideViewPager = findViewById<View>(R.id.slideContainer) as ViewPager



        imageList = mutableListOf()


        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)
        paysViewModel.paysImages.observe(this, Observer { paysWithImage ->
            Log.d(ContentValues.TAG,"9balll la boucle ta3 videos")
            for(item in paysWithImage)
            {
                Log.d(ContentValues.TAG, item.toString())
                if(item.pays.paysId == id_Pays){
                    Log.d(ContentValues.TAG, item.toString())
                    imageList= item.images as MutableList<ImagePays>
                    val adapter = SliderAdapter(this,imageList)
                    slideViewPager.adapter = adapter


                }
            }
        })



        // Tabs
        //toolBar.setTitle("Infos Pays")
        //setSupportActionBar(toolBar)




        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)
        paysViewModel.allPays.observe(this, Observer { paysliste ->
            Log.d(ContentValues.TAG,"début boucle")
            for(item in paysliste)
            {
                Log.d(ContentValues.TAG, item.toString())
                if(item.paysId == id_Pays){
                    Log.d(ContentValues.TAG, item.toString())
                     nomPays= findViewById<TextView>(R.id.countryName)
                    nomPays.setText(item.info.name)



                }
            }
        })

        tabLayout.setupWithViewPager(viewPager)
    }
}
