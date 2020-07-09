package com.example.geomob_encyclopedie_geographique

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geomob_encyclopedie_geographique.DataRoom.Pays
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var paysViewModel: PaysViewModel
    private lateinit var countryAdapter: CountryAdapter
    private var countryList:MutableList<Pays> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)
        paysViewModel.allPays.observe(this, Observer { countries ->
            countryList = countries as MutableList<Pays>
            countryAdapter = CountryAdapter(countryList)
            countrylist.apply {
                adapter = countryAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            countryAdapter.onItemClick = {paysId ->
                val intent = Intent(this, CountryInfoActivity::class.java)
                intent.putExtra("id_Pays",paysId)
                startActivity(intent)
            }
        })

    }
}



