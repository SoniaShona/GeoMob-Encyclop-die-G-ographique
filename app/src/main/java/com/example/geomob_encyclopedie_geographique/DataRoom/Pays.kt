package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.room.*

@Entity(tableName = "pays" )
data class Pays (
    @PrimaryKey(autoGenerate = true) val paysId: Int,
    @Embedded
    val info: Info,
    @ColumnInfo(name = "drapeauUrl") val drapeauUrl: String,
    @ColumnInfo(name = "hymneUrl") val hymneUrl: String
)



