package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PaysDao {
    @Query("SELECT * from pays")
    fun getPays(): LiveData<List<Pays>>

    @Query("SELECT * from pays WHERE paysId= :idP")
    fun getPaysById(idP: Int): LiveData<Pays>

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

    @Transaction
    @Query("SELECT * FROM pays WHERE paysId = :idP")
    fun getPaysWithVideosById(idP:Int): LiveData<PaysWithVideo>

    @Transaction
    @Query("SELECT * FROM pays WHERE paysId = :idP")
    fun getPaysWithImagesById(idP:Int): LiveData<PaysWithImage>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pays: Pays)

    @Insert
    suspend fun insertAll(paysList:List<Pays>)

    @Query("DELETE FROM pays")
    suspend fun deleteAll()

    @Update
    suspend fun update(pays: Pays)


    @Query("UPDATE pays SET visited=:visite WHERE paysId = :idP")
    fun updateVisited(idP : Int,visite : Boolean)
}