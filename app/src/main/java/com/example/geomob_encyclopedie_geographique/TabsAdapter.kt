package com.example.geomob_encyclopedie_geographique

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class TabsAdapter(fm: FragmentManager, idPays:Int) : FragmentPagerAdapter(fm) {
        val id :Int = idPays
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 ->return initFragment( InfoCountryTab())
            1 -> return initFragment(ImagesVideosCountryTab())
            else ->return initFragment(TweetsCountryTab())

        }
    }

    private fun initFragment(frag: Fragment):Fragment{
        val bundle = Bundle()
        Log.d(ContentValues.TAG,"dakhal TabsAdapter "+ id )
        bundle.putInt("idPays",id)
        val fragment = frag
        fragment.arguments= bundle
        return fragment
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