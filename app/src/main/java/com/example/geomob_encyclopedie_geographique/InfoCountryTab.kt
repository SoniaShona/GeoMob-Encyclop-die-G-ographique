package com.example.geomob_encyclopedie_geographique

import android.app.Activity
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel
import com.example.geomob_encyclopedie_geographique.DataRoom.Personnalite
import com.example.geomob_encyclopedie_geographique.DataRoom.Ressource
import com.example.geomob_encyclopedie_geographique.DataRoom.VideoPays
import com.example.geomob_encyclopedie_geographique.HandlerReq.Companion.getInstance
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_images_videos_country_tab.*
import kotlinx.android.synthetic.main.fragment_info_country_tab.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.net.URISyntaxException


class InfoCountryTab : BaseFragment() {
    private lateinit var paysViewModel: PaysViewModel
    private var mp: MediaPlayer? = null
    lateinit var mRequestQueue : RequestQueue
    private var urlWiki:String = ""

    private var resId:Int = 1

    private lateinit var descriptionPays : TextView
    private lateinit var drapeauPays : ImageView
    private lateinit var surfacePays : TextView
    private lateinit var populationPays : TextView
    private lateinit var datehistoriquePays : TextView
    private lateinit var historiquePays : TextView
    private lateinit var btnPlayAudio : Button

    private lateinit var layoutMgrPrsn: LinearLayoutManager
    private lateinit var layoutMgrRsrc: LinearLayoutManager


    private lateinit var personnaliteAdapter:PersonnaliteAdapter
    private lateinit var ressourceAdapter:RessourceAdapter

    lateinit var personnaliteList:MutableList<Personnalite>
    lateinit var ressourceList:MutableList<Ressource>

    private var v: View?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_info_country_tab, container, false)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //get coutry id
        val idPays = arguments!!.getInt("idPays")
        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)
        //init views
        initView()
        //init info country
        initInfo(idPays,paysViewModel)
        //init personnalités
        initPersonnalite(idPays,paysViewModel)
        //init ressource country
        initRessource(idPays,paysViewModel)


    }

    fun initView(){
        descriptionPays = v!!.findViewById<TextView>(R.id.description)
        drapeauPays = v!!.findViewById<ImageView>(R.id.flag)
        populationPays= v!!.findViewById(R.id.population)
        surfacePays= v!!.findViewById(R.id.superficie)
        datehistoriquePays= v!!.findViewById(R.id.datehis)
        historiquePays= v!!.findViewById(R.id.historique)
        btnPlayAudio = v!!.findViewById(R.id.btnPlayAudio)
    }

    fun initInfo(idPays:Int,viewModel:PaysViewModel){
        viewModel.getPaysById(idPays).observe(viewLifecycleOwner, Observer { pays ->
            urlWiki = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=${pays.info.name}"
            Log.d(TAG, " urlWiki : " + urlWiki )
            val jsonRequestDescription = JsonObjectRequest(
                Request.Method.GET, urlWiki, null,
                Response.Listener { response ->
                    val pages = response.getJSONObject("query").getJSONObject("pages")
                    if (pages.length() > 0){
                        val nPage = pages.names().get(0).toString()
                        val description = pages.getJSONObject(nPage).getString("extract")
                        Log.d(TAG,"description" + description)
                        descriptionPays.text = description
                    }else{
                        val description = "No Description was found"
                    }

                },
                Response.ErrorListener {
                    Log.d("Error", "Request error")

                })

            getInstance(activity!!).addToRequestQueue(jsonRequestDescription)
            drapeauPays.setImageResource(pays.drapeauUrl.toInt())
            populationPays.setText(pays.info.population)
            surfacePays.setText(pays.info.surface)
            datehistoriquePays.setText(pays.info.date_historique)
            historiquePays.setText(pays.info.desc_historique)
            resId = pays.hymneUrl.toInt()
            btnPlayAudio.setOnClickListener { lireAudio(resId) }
        })
    }

    fun initRessource(idPays:Int,viewModel:PaysViewModel){
        viewModel.paysRessource.observe(viewLifecycleOwner, Observer { paysWithRessources ->

            for(item in paysWithRessources)
            {
                if(item.pays.paysId == idPays){
                    ressourceList= item.ressources as MutableList<Ressource>
                    ressourceAdapter = RessourceAdapter(ressourceList)
                    layoutMgrRsrc = LinearLayoutManager(activity)
                    recycler_view_ressource.apply {
                        adapter=ressourceAdapter
                        layoutManager= layoutMgrRsrc
                    }

                }
            }
        })
    }
    fun initPersonnalite(idPays:Int,viewModel:PaysViewModel){
        viewModel.paysPersonnalites.observe(viewLifecycleOwner, Observer { paysWithPersonnalites ->

            for(item in paysWithPersonnalites)
            {
                if(item.pays.paysId == idPays){
                    personnaliteList= item.personnalites as MutableList<Personnalite>
                    personnaliteAdapter = PersonnaliteAdapter(personnaliteList)
                    layoutMgrPrsn = LinearLayoutManager(activity)
                    recycler_view_personnalite.apply {
                        adapter=personnaliteAdapter
                        layoutManager= layoutMgrPrsn
                    }

                }
            }
        })
    }

    fun lireAudio(resId: Int) {
        if (mp == null) {        //set up MediaPlayer
            mp = MediaPlayer.create(activity,resId)

            try {
                mp!!.prepare()

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        if (!mp!!.isPlaying())
            mp!!.start()
        else
            mp!!.pause()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            val a: Activity? = activity
            if (a != null) a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        }
    }

}
