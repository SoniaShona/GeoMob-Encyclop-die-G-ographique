package com.example.geomob_encyclopedie_geographique

import android.content.ComponentName
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.media.session.MediaSession
import android.net.Uri
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.VideoPays
import android.widget.MediaController
import androidx.annotation.NonNull
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import java.util.regex.Matcher
import java.util.regex.Pattern


class VideoAdapter(private val dataList:MutableList<VideoPays>): RecyclerView.Adapter<VideoAdapter.HolderVideo>()  {
        private lateinit var contxt: Context
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderVideo {
            contxt= parent.context
            val inflater = LayoutInflater.from(parent.context)
            return HolderVideo(inflater, parent)
        }

        override fun getItemCount(): Int {
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
            //ExoPlayer
            /*private var videoView: PlayerView?= null
            private var exoPlayer: ExoPlayer? = null
            private var playbackStateBuilder : PlaybackStateCompat.Builder? = null
            private var mediaSession: MediaSessionCompat? = null*/

            //YoutubePlayer
            private var videoView: YouTubePlayerView?= null
            init {
                videoView=itemView.findViewById(R.id.videoView)
            }

            fun bind(video: VideoPays) {
                //ExoPlayer
               /* val trackSelector = DefaultTrackSelector()
                exoPlayer = ExoPlayerFactory.newSimpleInstance(contxt, trackSelector)
                videoView?.player = exoPlayer

                val userAgent = Util.getUserAgent(contxt, "paysVideos")
                val mediaUri = Uri.parse(video.videoUrl)
                val mediaSource = ExtractorMediaSource(mediaUri, DefaultDataSourceFactory(contxt, userAgent), DefaultExtractorsFactory(), null, null)

                exoPlayer?.prepare(mediaSource)

                val componentName = ComponentName(contxt, "paysVideos")
                mediaSession = MediaSessionCompat(contxt, "ExoPlayer", componentName, null)

                playbackStateBuilder = PlaybackStateCompat.Builder()

                playbackStateBuilder?.setActions(PlaybackStateCompat.ACTION_PLAY or PlaybackStateCompat.ACTION_PAUSE or
                        PlaybackStateCompat.ACTION_FAST_FORWARD)

                mediaSession?.setPlaybackState(playbackStateBuilder?.build())
                mediaSession?.isActive = true*/
                // fin ExoPlayer
                //YoutubePlayer
                videoView!!.getPlayerUiController().showFullscreenButton(true)
                videoView!!.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                        val videoId = getId(video.videoUrl)
                        Log.d(ContentValues.TAG,videoId)
                        youTubePlayer.cueVideo(videoId, 0f)
                    }
                })

            }

            private fun getId(url:String):String{
                val pattern =
                    "(?<=watch\\?v=|/videos/|embed/|youtu.be/|/v/|/e/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#&?\\n]*"
                var ubId=""
                val compiledPattern: Pattern = Pattern.compile(pattern)
                val matcher: Matcher =
                    compiledPattern.matcher(url) //url is youtube url for which you want to extract the id.

                if (matcher.find()) {
                    ubId= matcher.group()
                }
                return ubId
            }
                // fin YoutubePlayer

            }
}