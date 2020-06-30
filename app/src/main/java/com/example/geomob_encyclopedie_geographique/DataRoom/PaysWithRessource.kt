package com.example.geomob_encyclopedie_geographique.DataRoom

import androidx.room.Embedded
import androidx.room.Relation

data class PaysWithRessource (
    @Embedded val pays: Pays,
    @Relation(
        parentColumn = "paysId",
        entityColumn = "paysPossesorId"
    )
    val ressources: List<Ressource>
)