package com.example.geomob_encyclopedie_geographique

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.ImagePays
import com.example.geomob_encyclopedie_geographique.DataRoom.Pays


class CountryAdapter(private val dataList:MutableList<Pays>): RecyclerView.Adapter<CountryAdapter.HolderCountry>(){

    var onItemClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCountry {
        val inflater = LayoutInflater.from(parent.context)
        return HolderCountry(inflater, parent)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: HolderCountry, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }



    /***********************HolderView**********************/

    inner class HolderCountry(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(
            inflater.inflate(
                R.layout.country_item,
                parent, false
            )
        ) {
        private var flagView :ImageView? = null
        private var nameView :TextView?= null

        init {
            flagView = itemView.findViewById(R.id.countryFlagListItem)
            nameView = itemView.findViewById(R.id.countryNameListItem)
        }

        fun bind(pays: Pays) {
            flagView?.setImageResource(pays.drapeauUrl.toInt())
            nameView?.text = pays.info.name

            itemView.setOnClickListener {
                onItemClick?.invoke(pays.paysId)
            }
        }

    }
}
