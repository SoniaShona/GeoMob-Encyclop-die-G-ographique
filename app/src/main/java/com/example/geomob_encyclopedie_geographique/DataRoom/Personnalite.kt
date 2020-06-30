package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "personnalite",foreignKeys = arrayOf(
    ForeignKey(
        entity = Pays::class,
        parentColumns = arrayOf("paysId"),
        childColumns = arrayOf("paysPossesorId"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )))
data class Personnalite (
    @PrimaryKey(autoGenerate = true) val id_personnalite:Int,
    @ColumnInfo(name = "paysPossesorId") val paysPossesorId:Int,
    @ColumnInfo(name = "nom") val nom:String,
    @ColumnInfo(name = "imageUrl") val imageUrl:String,
    @ColumnInfo(name = "description") val description:String
)