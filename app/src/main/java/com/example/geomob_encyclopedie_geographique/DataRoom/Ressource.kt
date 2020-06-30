package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "ressource",foreignKeys = arrayOf(
    ForeignKey(
        entity = Pays::class,
        parentColumns = arrayOf("paysId"),
        childColumns = arrayOf("paysPossesorId"),
        onUpdate = CASCADE,
        onDelete = CASCADE
    ))
)
data class Ressource (
    @PrimaryKey(autoGenerate = true) val id_ressource:Int,
    @ColumnInfo(name = "paysPossesorId") val paysPossesorId:Int,
    @ColumnInfo(name = "nom") val nom:String,
    @ColumnInfo(name = "imageUrl") val imageUrl:String,
    @ColumnInfo(name = "description") val description:String
)