package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Info (
    val description: String,
    val surface: String,
    val population: String,
    val date_historique: String,
    val desc_historique: String
)