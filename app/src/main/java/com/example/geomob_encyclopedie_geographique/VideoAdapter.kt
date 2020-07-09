package com.example.geomob_encyclopedie_geographique

import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.VideoPays
import android.widget.MediaController


class VideoAdapter(private val dataList:MutableList<VideoPays>): RecyclerView.Adapter<VideoAdapter.HolderVideo>()  {
        private lateinit var contxt: Context
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderVideo {
            contxt= parent.context
            val inflater = LayoutInflater.from(parent.context)
            return HolderVideo(inflater, parent)
        }

        override fun getItemCount(): Int {
            Log.d(TAG,"dataList.size : " + dataList.size.toString())
            return dataList.size
        }

        override fun onBindViewHolder(holder: HolderVideo, position: Int) {
            val data = dataList[position]
            Log.d(TAG,"dakhal onBindViewholder")
            Log.d(TAG,data.toString())
            holder.bind(data)
        }



        /***********************HolderView**********************/

        inner class HolderVideo(inflater: LayoutInflater, parent: ViewGroup) :
            RecyclerView.ViewHolder(
                inflater.inflate(
                    R.layout.item_video_view,
                    parent, false
                )
            ) {

            private var videoView: VideoView?= null
            private var controller: MediaController? = null

            init {
                videoView=itemView.findViewById(R.id.videoView)
            }

            fun bind(video: VideoPays) {
                    controller = MediaController(contxt)
                    videoView?.setMediaController(controller)
                    val videourl = Uri.parse("android.resource://" + contxt.packageName + "/"
                            + video.videoUrl.toInt()) //do not add any extension
                    videoView?.setVideoURI(videourl)
        }
    }
}