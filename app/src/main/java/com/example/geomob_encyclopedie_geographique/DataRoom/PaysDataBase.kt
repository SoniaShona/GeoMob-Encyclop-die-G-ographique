package com.example.geomob_encyclopedie_geographique.DataRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Pays::class, ImagePays::class, VideoPays::class, Ressource::class, Personnalite::class),
    version = 1, exportSchema = false)
// Annotates class to be a Room Database with a table (entity) of the Word class

public abstract class PaysDataBase : RoomDatabase() {

        abstract fun imageDao(): ImageDao
        abstract fun videoDao(): VideoDao
        abstract fun personnaliteDao(): PersonnaliteDao
        abstract fun ressourceDao(): RessourceDao

        companion object {
            // Singleton prevents multiple instances of database opening at the
            // same time.
            @Volatile
            private var INSTANCE: PaysDataBase? = null

            fun getDatabase(context: Context): PaysDataBase {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        PaysDataBase::class.java,
                        "pays_database"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}