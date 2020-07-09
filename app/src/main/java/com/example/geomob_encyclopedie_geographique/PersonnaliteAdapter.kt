

package com.example.geomob_encyclopedie_geographique

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.ImagePays
import com.example.geomob_encyclopedie_geographique.DataRoom.Personnalite
import com.example.geomob_encyclopedie_geographique.DataRoom.Tweet
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class PersonnaliteAdapter(private val dataList:MutableList<Personnalite>): RecyclerView.Adapter<PersonnaliteAdapter.HolderTweet>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderTweet {
        val inflater = LayoutInflater.from(parent.context)
        return HolderTweet(inflater, parent)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: HolderTweet, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }



    /***********************HolderView**********************/

    inner class HolderTweet(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(
            inflater.inflate(
                R.layout.item_personnalite_view,
                parent, false
            )
        ) {

        private var namePersonnalite :TextView?= null
        private var descPersonnalite :TextView?= null
        private var personnalitePic: ImageView?= null

        init {
            namePersonnalite = itemView.findViewById(R.id.personnaliteName)
            descPersonnalite = itemView.findViewById(R.id.personnaliteDescp)
            personnalitePic= itemView.findViewById(R.id.personnalitePic)
        }

        fun bind(prsn: Personnalite) {
            namePersonnalite?.text =prsn.nom
            descPersonnalite?.text = prsn.description
            personnalitePic?.setImageResource(prsn.imageUrl.toInt())
        }

    }
}