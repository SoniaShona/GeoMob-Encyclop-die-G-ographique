package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "video_pays",foreignKeys = arrayOf(
        ForeignKey(
                entity = Pays::class,
                parentColumns = arrayOf("paysId"),
                childColumns = arrayOf("paysPossesorId"),
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE
        ))
)

data class VideoPays (
        @PrimaryKey(autoGenerate = true) val id_video: Int,
        @androidx.room.ColumnInfo(name = "paysPossesorId") val paysPossesorId:Int,
        @ColumnInfo(name = "videoUrl") val videoUrl: String
)
