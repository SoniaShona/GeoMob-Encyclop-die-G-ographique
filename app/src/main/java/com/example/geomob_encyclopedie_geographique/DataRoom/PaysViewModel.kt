package com.example.geomob_encyclopedie_geographique.DataRoom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaysViewModel(application: Application) : AndroidViewModel(application) {
    val allPays:LiveData<List<Pays>>
    val paysVideos:LiveData<List<PaysWithVideo>>
    val paysImages:LiveData<List<PaysWithImage>>
    val paysPersonnalites:LiveData<List<PaysWithPersonnalite>>


    val paysDao:PaysDao

    init {
        paysDao = PaysDataBase.getDatabase(application,viewModelScope).paysDao()
        allPays = paysDao.getPays()
        paysVideos = paysDao.getPaysWithVideos()
        paysImages = paysDao.getPaysWithImages()
        paysPersonnalites = paysDao.getPaysWithPersonnalites()
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(pays: Pays) = viewModelScope.launch(Dispatchers.IO) {
        paysDao.insert(pays)
    }

    /*fun getById(idP: Int):PaysWithVideo{
        val pays = paysDao.getPaysWithVideosById(idP)
        return pays
    }*/

    fun getPaysById(idP: Int):LiveData<Pays>{
        val pays = paysDao.getPaysById(idP)
        return pays
    }
}