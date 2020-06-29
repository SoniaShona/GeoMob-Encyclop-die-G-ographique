package com.example.geomob_encyclopedie_geographique

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class TabsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> return InfoCountryTab()
            1 -> return ImagesVideosCountryTab()
            else -> return TweetsCountryTab()

        }
    }


    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Information"
            1 -> return "Photos et Videos"
            2 -> return "Tweets"
        }
        return null
    }
}