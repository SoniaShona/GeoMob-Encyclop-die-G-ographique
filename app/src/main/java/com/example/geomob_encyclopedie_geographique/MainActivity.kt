package com.example.geomob_encyclopedie_geographique

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.Pays
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var paysViewModel: PaysViewModel

    private lateinit var adapter: RecyclerViewAdapter
    internal lateinit var list : RecyclerView

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)

        //list = findViewById<View>(R.id.countrylist) as RecyclerView

        //paysViewModel.allPays.observe(this, Observer {pays ->
         //   var countries= pays as MutableList<Pays>
           // adapter = RecyclerViewAdapter(this,countries)
            //list.adapter = adapter

        //})

        //adapter = RecyclerViewAdapter(this,countries)
        //list.adapter = adapter
        //listView.setOnItemClickListener { parent, view, position, id ->
        //    val intent = Intent(this, CountryInfoActivity::class.java)
        //    intent.putExtra("country",countries.get(position).paysId)
        //    startActivity(intent)
        //}







        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)
        Log.d(ContentValues.TAG , "avant de commencer")

        paysViewModel.allPays.observe(this, Observer { pays ->
            for( item in pays){
                Log.d(ContentValues.TAG, item.toString())

            }
        })

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            val intent = Intent(this, CountryInfoActivity::class.java)
            intent.putExtra("id_Pays",1)
            startActivity(intent)
        }
    }
}



