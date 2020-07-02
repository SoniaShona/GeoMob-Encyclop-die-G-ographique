package com.example.geomob_encyclopedie_geographique.DataRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.geomob_encyclopedie_geographique.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Pays::class, ImagePays::class, VideoPays::class, Ressource::class, Personnalite::class),
    version = 2, exportSchema = false)

public abstract class PaysDataBase : RoomDatabase() {

        abstract fun imageDao(): ImageDao
        abstract fun videoDao(): VideoDao
        abstract fun personnaliteDao(): PersonnaliteDao
        abstract fun ressourceDao(): RessourceDao
        abstract fun paysDao(): PaysDao

    private class PaysDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    val paysDao = database.paysDao()
                    val videoDao = database.videoDao()
                    val imageDao = database.imageDao()

                    // Delete all content here.
                    paysDao.deleteAll()

                    // Add sample words.
                    var pays =Pays(1,
                        Info("balbala","12655","135455", "12/12/2020","grrrr"),"drrrr","ffffff"
                    )
                    paysDao.insert(pays)
                    pays = Pays(2,
                        Info("balbala2","126552","1354552", "12/12/2020","grrrr2"),"drrrr2","ffffff2"
                    )
                    paysDao.insert(pays)

                    var video = VideoPays(10,1, R.raw.videoplayback.toString())
                    videoDao.insert(video)
                    video = VideoPays(11,1, R.raw.videoplayback1.toString())
                    videoDao.insert(video)

                    var image = ImagePays(20,1,R.drawable.algerie1.toString())
                    imageDao.insert(image)
                    image = ImagePays(21,1,R.drawable.algerie2.toString())
                    imageDao.insert(image)


                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: PaysDataBase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PaysDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PaysDataBase::class.java,
                    "pays_database"
                )
                    .addCallback(PaysDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
