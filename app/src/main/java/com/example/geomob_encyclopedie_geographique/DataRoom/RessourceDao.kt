package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RessourceDao {
    @Query("SELECT * from ressource")
    fun getRessources(): LiveData<List<Ressource>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(res: Ressource)

    @Insert
    suspend fun insertAll(ressourceList:List<Ressource>)

    @Query("DELETE FROM ressource")
    suspend fun deleteAll()

    @Update
    suspend fun update(res: Ressource)
}