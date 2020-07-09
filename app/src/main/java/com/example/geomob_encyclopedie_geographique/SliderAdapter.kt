package com.example.geomob_encyclopedie_geographique

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.geomob_encyclopedie_geographique.DataRoom.ImagePays

class SliderAdapter(private val context : Context, private val liste : MutableList<ImagePays>) : PagerAdapter() {

    private var layoutInflater : LayoutInflater?= null
    //private var images = arrayOf(R.drawable.algerie1 , R.drawable.algerie2 , R.drawable.algerie3 )

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return liste.size
    }

    @SuppressLint("ServiceCast")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater!!.inflate(R.layout.custom_layout, null)
        val image = v.findViewById<View>(R.id.slideImage) as ImageView

        image.setImageResource(liste[position].imgUrl.toInt())

        val vp = container as ViewPager
        vp.addView(v , 0)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val v = `object` as View
        vp.removeView(v)
    }

}