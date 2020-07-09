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
import com.example.geomob_encyclopedie_geographique.DataRoom.Ressource
import com.example.geomob_encyclopedie_geographique.DataRoom.Tweet
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class RessourceAdapter(private val dataList:MutableList<Ressource>): RecyclerView.Adapter<RessourceAdapter.HolderTweet>() {

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
                R.layout.item_ressource_view,
                parent, false
            )
        ) {

        private var nameRessource :TextView?= null
        private var descRessource :TextView?= null
        private var ressourcePic: ImageView?= null

        init {
            nameRessource = itemView.findViewById(R.id.RessourceName)
            descRessource = itemView.findViewById(R.id.RessourceDescp)
            ressourcePic= itemView.findViewById(R.id.RessourcePic)
        }

        fun bind(rsrc : Ressource) {
            nameRessource?.text =rsrc.nom
            descRessource?.text = rsrc.description
            ressourcePic?.setImageResource(rsrc.imageUrl.toInt())
        }

    }
}