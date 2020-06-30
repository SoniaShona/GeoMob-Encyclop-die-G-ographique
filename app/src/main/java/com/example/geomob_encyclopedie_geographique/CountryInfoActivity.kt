package com.example.geomob_encyclopedie_geographique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_country_info.*


class CountryInfoActivity : AppCompatActivity() {

    //Slide Show
    internal lateinit var slideViewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)

        //Slideshow
        slideViewPager = findViewById<View>(R.id.slideContainer) as ViewPager
        val adapter = SliderAdapter(this)
        slideViewPager.adapter = adapter

        // Tabs
        //toolBar.setTitle("Infos Pays")
        //setSupportActionBar(toolBar)


        val FragmentAdapter = TabsAdapter(supportFragmentManager)
        viewPager.adapter = FragmentAdapter

        tabLayout.setupWithViewPager(viewPager)
    }
}
