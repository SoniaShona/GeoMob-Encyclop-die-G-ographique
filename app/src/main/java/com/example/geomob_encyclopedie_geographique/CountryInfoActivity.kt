package com.example.geomob_encyclopedie_geographique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.View
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.geomob_encyclopedie_geographique.DataRoom.Pays
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_country_info.*
import kotlinx.android.synthetic.main.fragment_info_country_tab.*


class CountryInfoActivity : AppCompatActivity() {

    //Slide Show
    internal lateinit var slideViewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)

        //var countryId = intent.getIntExtra("country",0)
        //xxx.text = countryId.toString()


        //Slideshow
        slideViewPager = findViewById<View>(R.id.slideContainer) as ViewPager
        val adapter = SliderAdapter(this)
        slideViewPager.adapter = adapter

        // Tabs
        //toolBar.setTitle("Infos Pays")
        //setSupportActionBar(toolBar)

        //get id of country
        val id_Pays = intent.getIntExtra("id_Pays",0)
        val FragmentAdapter = TabsAdapter(supportFragmentManager,id_Pays)
        viewPager.adapter = FragmentAdapter

        tabLayout.setupWithViewPager(viewPager)
    }
}
