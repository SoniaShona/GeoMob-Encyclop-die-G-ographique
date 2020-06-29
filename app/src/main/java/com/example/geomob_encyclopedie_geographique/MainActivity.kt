package com.example.geomob_encyclopedie_geographique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener{
            val intent = Intent(this, CountryInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
