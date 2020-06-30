package com.example.geomob_encyclopedie_geographique

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var paysViewModel: PaysViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)
        paysViewModel.allPays.observe(this, Observer { pays ->
            for( item in pays){
                Log.d(ContentValues.TAG, item.toString())
            }
        })

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            val intent = Intent(this, CountryInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
