package com.example.geomob_encyclopedie_geographique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    internal lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<View>(R.id.countryListView) as ListView






        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            val intent = Intent(this, CountryInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
