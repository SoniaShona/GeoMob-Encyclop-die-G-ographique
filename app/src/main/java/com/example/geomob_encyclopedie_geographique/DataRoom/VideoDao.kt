package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VideoDao {
    @Query("SELECT * from video_pays")
    fun getVideos(): LiveData<List<VideoPays>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(video: VideoPays)

    @Insert
    suspend fun insertAll(videoList:List<VideoPays>)

    @Query("DELETE FROM video_pays")
    suspend fun deleteAll()

    @Update
    suspend fun update(video: VideoPays)
}