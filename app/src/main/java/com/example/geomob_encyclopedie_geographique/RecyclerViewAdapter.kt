package com.example.geomob_encyclopedie_geographique

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.Pays
import kotlinx.android.synthetic.main.activity_country_info.view.*


class RecyclerViewAdapter (private val context: Context?, private var countries: MutableList<Pays>) :
    RecyclerView.Adapter<RecyclerViewAdapter.CountryHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val view = inflater.inflate(R.layout.list_content,parent,false)
        return CountryHolder(view)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        val current = countries[position]
        holder.setData(current, position)
        //holder.itemView.setOnClickListener {
            //val intent = Intent(context, CountryInfoActivity::class.java)
            //intent.putExtra("pays",current)

            //if (context != null) {
            //   context.startActivity(intent)
            //}

        //}

    }

    override fun getItemCount(): Int = countries.size



    inner class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //private var position : Int = 0
        lateinit var currentCountry : Pays
        //private val countryFalg: ImageView? = null

        fun setData (currentCountry : Pays , position: Int) {
            itemView.countryName.text = currentCountry.info.description
            //this.position = position
            this.currentCountry = currentCountry
        }
    }
}