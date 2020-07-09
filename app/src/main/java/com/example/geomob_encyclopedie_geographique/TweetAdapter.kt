package com.example.geomob_encyclopedie_geographique

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.ImagePays
import com.example.geomob_encyclopedie_geographique.DataRoom.Tweet
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class TweetAdapter(private val dataList:MutableList<Tweet>): RecyclerView.Adapter<TweetAdapter.HolderTweet>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderTweet {
        val inflater = LayoutInflater.from(parent.context)
        return HolderTweet(inflater, parent)
    }

    override fun getItemCount(): Int {
        Log.d(ContentValues.TAG,"dataList dakhal adapter "+   dataList.size)
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
                R.layout.item_tweet_view,
                parent, false
            )
        ) {

        private var nameUser :TextView?= null
        private var nameScreenUser:TextView?= null
        private var userPic: ImageView?= null
        private var content:TextView?= null

        init {
            nameUser = itemView.findViewById(R.id.userName)
            nameScreenUser = itemView.findViewById(R.id.userNameScreen)
            userPic= itemView.findViewById(R.id.UserPic)
            content = itemView.findViewById(R.id.tweetContent)
        }

        fun bind(tweet: Tweet) {
            nameUser?.text =tweet.userName
            nameScreenUser?.text = tweet.userNameScreen
            content?.text = tweet.content

            Picasso.get()
                .load(tweet.userImageUrl)
                .into(userPic, object : Callback {
                    override fun onSuccess() {
                        Log.d(ContentValues.TAG, "success")
                    }
                    override fun onError(e: Exception?) {
                        Log.d(ContentValues.TAG, "error")
                    }
                })
        }

    }
}