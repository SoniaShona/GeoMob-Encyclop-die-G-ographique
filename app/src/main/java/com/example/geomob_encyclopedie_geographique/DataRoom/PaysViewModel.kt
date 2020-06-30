package com.example.geomob_encyclopedie_geographique.DataRoom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaysViewModel(application: Application) : AndroidViewModel(application) {
    val allPays:LiveData<List<Pays>>
    val paysDao:PaysDao

    init {
        paysDao = PaysDataBase.getDatabase(application,viewModelScope).paysDao()
        allPays = paysDao.getPays()
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(pays: Pays) = viewModelScope.launch(Dispatchers.IO) {
        paysDao.insert(pays)
    }
}