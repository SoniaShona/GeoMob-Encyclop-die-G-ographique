package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonnaliteDao {
    @Query("SELECT * from personnalite")
    fun getPersonnalite(): LiveData<List<Personnalite>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(res: Personnalite)

    @Insert
    suspend fun insertAll(personnaliteList:List<Personnalite>)

    @Query("DELETE FROM personnalite")
    suspend fun deleteAll()

    @Update
    suspend fun update(res: Personnalite)
}