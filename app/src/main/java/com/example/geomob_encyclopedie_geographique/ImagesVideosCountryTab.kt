package com.example.geomob_encyclopedie_geographique

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geomob_encyclopedie_geographique.DataRoom.ImagePays
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel
import com.example.geomob_encyclopedie_geographique.DataRoom.VideoPays
import kotlinx.android.synthetic.main.fragment_images_videos_country_tab.*

class ImagesVideosCountryTab : Fragment() {
    private lateinit var paysViewModel: PaysViewModel

    private lateinit var videoAdapter: VideoAdapter
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var layoutMgrImg: GridLayoutManager
    private lateinit var layoutMgrVd: LinearLayoutManager

    lateinit var imageList:MutableList<ImagePays>
    lateinit var videoList:MutableList<VideoPays>

    private var v: View?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v= inflater.inflate(R.layout.fragment_images_videos_country_tab, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idPays = arguments!!.getInt("idPays")
        Log.d(TAG,"idPays : " + idPays)

        imageList = mutableListOf()
        videoList = mutableListOf()

        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)
        paysViewModel.paysVideos.observe(viewLifecycleOwner, Observer { paysWithVideo ->
            Log.d(TAG,"9balll la boucle ta3 videos")
            for(item in paysWithVideo)
            {
                Log.d(TAG, item.toString())
                if(item.pays.paysId == idPays){
                    Log.d(TAG, item.toString())
                    videoList= item.videos as MutableList<VideoPays>
                    videoAdapter= VideoAdapter(videoList)
                    layoutMgrVd= LinearLayoutManager(activity)
                    recycler_view_videos.apply {
                        adapter=videoAdapter
                        layoutManager= layoutMgrVd
                    }

                }
            }
        })
        /*val pays = paysViewModel.getById(idPays)
        Log.d(TAG, "Pays" + pays.toString())
        videoList= pays.videos as MutableList<VideoPays>
        Log.d(TAG, "videos of Pays" + videoList.toString())

        videoAdapter= VideoAdapter(videoList)
        layoutMgrVd= LinearLayoutManager(activity)
        recycler_view_videos.apply {
            adapter=videoAdapter
            layoutManager= layoutMgrVd
        }*/

        paysViewModel.paysImages.observe(viewLifecycleOwner, Observer { paysWithImages ->
            for(item in paysWithImages)
            {
                if(item.pays.paysId == idPays){
                    imageList= item.images as MutableList<ImagePays>
                    imageAdapter= ImageAdapter(imageList)

                    layoutMgrImg= GridLayoutManager(activity,3)
                    recycler_view_images.apply {
                        adapter=imageAdapter
                        layoutManager= layoutMgrImg
                    }
                    break
                }
            }
        })


    }

    companion object {
        fun newInstance(): ImagesVideosCountryTab = ImagesVideosCountryTab()
    }
}
