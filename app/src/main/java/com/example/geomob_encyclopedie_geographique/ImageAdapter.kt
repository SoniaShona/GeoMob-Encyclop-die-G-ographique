package com.example.geomob_encyclopedie_geographique

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.ImagePays

class ImageAdapter(private val dataList:MutableList<ImagePays>): RecyclerView.Adapter<ImageAdapter.HolderImage>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderImage {
        val inflater = LayoutInflater.from(parent.context)
        return HolderImage(inflater, parent)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: HolderImage, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }



    /***********************HolderView**********************/

    inner class HolderImage(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(
            inflater.inflate(
                R.layout.item_image_view,
                parent, false
            )
        ) {

        private var img:ImageView?= null

        init {
            img=itemView.findViewById(R.id.imageView)
        }

        fun bind(image: ImagePays) {
            img?.setImageResource(image.imgUrl.toInt())
        }

    }
}