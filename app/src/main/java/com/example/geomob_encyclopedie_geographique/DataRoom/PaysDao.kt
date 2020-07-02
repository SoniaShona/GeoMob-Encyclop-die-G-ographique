package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PaysDao {
    @Query("SELECT * from pays")
    fun getPays(): LiveData<List<Pays>>

    @Transaction
    @Query("SELECT * FROM pays")
    fun getPaysWithRessources(): LiveData<List<PaysWithRessource>>

    @Transaction
    @Query("SELECT * FROM pays")
    fun getPaysWithPersonnalites(): LiveData<List<PaysWithPersonnalite>>

    @Transaction
    @Query("SELECT * FROM pays")
    fun getPaysWithImages(): LiveData<List<PaysWithImage>>

    @Transaction
    @Query("SELECT * FROM pays")
    fun getPaysWithVideos(): LiveData<List<PaysWithVideo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pays: Pays)

    @Insert
    suspend fun insertAll(paysList:List<Pays>)

    @Query("DELETE FROM pays")
    suspend fun deleteAll()

    @Update
    suspend fun update(pays: Pays)
}