package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "img_pays",foreignKeys = arrayOf(
    ForeignKey(
        entity = Pays::class,
        parentColumns = arrayOf("paysId"),
        childColumns = arrayOf("paysPossesorId"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )
))
class ImagePays (
    @PrimaryKey(autoGenerate = true) val id_Img: Int,
    @ColumnInfo(name = "paysPossesorId") val paysPossesorId:Int,
    @ColumnInfo(name = "imgUrl") val imgUrl: String
)