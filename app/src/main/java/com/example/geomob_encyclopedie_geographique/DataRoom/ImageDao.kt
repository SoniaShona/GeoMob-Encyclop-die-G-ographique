package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ImageDao {
    @Query("SELECT * from img_pays")
    fun getImages(): LiveData<List<ImagePays>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(img: ImagePays)

    @Insert
    suspend fun insertAll(imgList:List<ImagePays>)

    @Query("DELETE FROM img_pays")
    suspend fun deleteAll()

    @Update
    suspend fun update(img: ImagePays)
}