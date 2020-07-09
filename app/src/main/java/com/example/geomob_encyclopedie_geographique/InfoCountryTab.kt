package com.example.geomob_encyclopedie_geographique

import android.content.ClipDescription
import android.content.ContentValues
import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel


class InfoCountryTab : Fragment() {
    private lateinit var paysViewModel: PaysViewModel
    private var mp: MediaPlayer? = null

    private var resId:Int = 1


    private lateinit var descriptionPays : TextView
    private lateinit var drapeauPays : ImageView
    private lateinit var surfacePays : TextView
    private lateinit var populationPays : TextView
    private lateinit var datehistoriquePays : TextView
    private lateinit var historiquePays : TextView
    private lateinit var btnPlayAudio : Button

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idPays = arguments!!.getInt("idPays")
        Log.d(ContentValues.TAG,"idPays : " + idPays)

        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)
        paysViewModel.allPays.observe(viewLifecycleOwner, Observer { paysliste ->
            Log.d(ContentValues.TAG,"début boucle")
            for(item in paysliste)
            {
                Log.d(ContentValues.TAG, item.toString())
                if(item.paysId == idPays){
                    Log.d(ContentValues.TAG, item.toString())
                    descriptionPays = v!!.findViewById<TextView>(R.id.description)
                    descriptionPays.setText(item.info.description)

                    drapeauPays = v!!.findViewById<ImageView>(R.id.flag)
                    drapeauPays.setImageResource(item.drapeauUrl.toInt())

                    populationPays= v!!.findViewById(R.id.population)
                    populationPays.setText(item.info.population)

                    surfacePays= v!!.findViewById(R.id.superficie)
                    surfacePays.setText(item.info.surface)

                    datehistoriquePays= v!!.findViewById(R.id.datehis)
                    datehistoriquePays.setText(item.info.date_historique)

                    historiquePays= v!!.findViewById(R.id.historique)
                    historiquePays.setText(item.info.desc_historique)

                    resId = item.hymneUrl.toInt()
                    btnPlayAudio = v!!.findViewById(R.id.btnPlayAudio)
                    btnPlayAudio.setOnClickListener { lireAudio(resId) }


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

}
