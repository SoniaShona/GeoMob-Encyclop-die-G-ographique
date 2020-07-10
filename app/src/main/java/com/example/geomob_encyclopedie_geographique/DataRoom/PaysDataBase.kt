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
                    val personnaliteDao = database.personnaliteDao()
                    val ressourceDao = database.ressourceDao()

                    // Delete all content here.
                    paysDao.deleteAll()

                    // Add sample words.
                    var pays =Pays(1,
                        Info("USA","","9 833 517 km2","328 239 523 hab", "4 juillet 1776",
                            "La Déclaration unanime des treize États unis d’Amérique1 (en anglais : The unanimous declaration of the thirteen united States of America), généralement appelée « Déclaration d'indépendance des États-Unis d'Amérique », est un texte politique par lequel les treize colonies britanniques d'Amérique du Nord ont fait sécession de la Grande-Bretagne le 4 juillet 1776, pour former les « États-Unis d'Amérique ». Ce texte est marqué par l'influence de la philosophie des Lumières et tire également les conséquences de la Révolution anglaise de 1688 : d'après les abus constatés, les délégués des colons estiment qu'ils ont le droit et le devoir de se révolter contre la monarchie britannique (en fait, le Parlement britannique a voté de lourds impôts et taxes frappant les colonies). Depuis, le 4 juillet est devenu la fête nationale des États-Unis : l'Independence Day (« Jour de l'Indépendance » en français).\n" +
                                "\n" +
                                "Depuis 2005, elle est classée sur la Liste Mémoire du monde de l'UNESCO."),R.drawable.usaflag.toString(),R.raw.hymneusa.toString()
                    )
                    paysDao.insert(pays)


                    var image = ImagePays(20,1,R.drawable.usa3.toString())
                    imageDao.insert(image)
                    image = ImagePays(21,1,R.drawable.usa1.toString())
                    imageDao.insert(image)
                    image = ImagePays(22,1,R.drawable.usa2.toString())
                    imageDao.insert(image)
                    image = ImagePays(23,1,R.drawable.usa4.toString())
                    imageDao.insert(image)
                    image = ImagePays(24,1,R.drawable.usa5.toString())
                    imageDao.insert(image)


                    var personnalite = Personnalite(1,1,"Barack Obama",R.drawable.obama.toString(),"Barack Hussein Obama II /bəˈɹɑːk huːˈseɪn oʊˈbɑːmə/, né le 4 août 1961 à Honolulu, est un homme d'État américain. Il est le 44ᵉ président des États-Unis, en fonction du 20 janvier 2009 au 20 janvier 2017.")
                    personnaliteDao.insert(personnalite)
                    personnalite = Personnalite(2,1,"Donald Trump",R.drawable.trump.toString(),"Donald John Trump , né le 14 juin 1946 à New York, est un homme d'affaires, animateur de télévision et homme d'État américain, président des États-Unis depuis le 20 janvier 2017.")
                    personnaliteDao.insert(personnalite)


                    var ressource = Ressource(1,1,"Hollywood Sign, Los Angeles",R.drawable.usaressource1.toString(),"Le Hollywood Sign se trouve sur le versant sud du mont Lee, à l’ouest du Griffith Park de Los Angeles depuis 1923")
                    ressourceDao.insert(ressource)
                    ressource = Ressource(2,1,"Statue of Liberty National Monument",R.drawable.usaressource2.toString(),"A l’entrée du port de New York, la Statue de la Liberté éclaire encore aujourd’hui le monde du haut de ses 93 mètres et porte haut et fort des idéaux humanistes tels que les Droits de l’Homme, la paix, la liberté, la lutte contre l’oppression, l’alliance entre les nations, l’amitié franco-américaine… ")
                    ressourceDao.insert(ressource)
                    ressource = Ressource(3,1,"Golden Gate Bridge, San Francisco",R.drawable.usaressource3.toString(),"Le Golden Gate Bridge de San Francisco est l’une des splendeurs du monde moderne, à l’instar du monde antique et de ses 7 merveilles. Inauguré en 1937, gigantesque artère de communication entre la ville de San Francisco et le Marin County, le Golden Gate Bridge est l’emblème de la Californie et plus largement du monde occidental.")
                    ressourceDao.insert(ressource)








                    pays = Pays(2,
                        Info("France","balbala2","126552","1354552", "12/12/2020","grrrr2"),R.drawable.flag.toString(),"ffffff2"
                    )
                    paysDao.insert(pays)

                    pays = Pays(3, Info("Algérie","L'Algérie est un pays nord-africain doté d'un littoral sur la mer Méditerranée et d'un intérieur désertique, le Sahara. De nombreux empires y ont laissé leur marque, comme les anciennes ruines romaines de Tipasa, en bord de mer. Dans la capitale, Alger, des sites ottomans, tels que la mosquée Ketchaoua, datant de 1612 environ, bordent le quartier de la Casbah. Perché sur une colline, cet endroit dispose d'allées étroites et d'escaliers. La basilique Notre-Dame d'Afrique, arborant une architecture néo-byzantine, date de la domination coloniale française.","2 381 741 KM2","42 972 878 hab.","5 juillet 1962","C'est un jour qui ne ressemble à aucun autre. En ce 5 juillet 1962, l'Algérie fête, dans la frénésie, l'indépendance que doit proclamer le soir même le général de Gaulle. Cent trente-deux ans jour pour jour après la prise d'Alger par les Français. Hommes, femmes et enfants défilent dans les rues, au cri de \"Vive l'Algérie indépendante\", vêtus de leurs habits de fête, drapeaux du Front de libération nationale (FLN) au vent.\n" +
                            "\n" +
                            "\"C'est quelque chose qu'on ne vit qu'une fois. On a vu tous les villages, toute la population venir, les hommes, les femmes. Ils dansaient, ils chantaient. On se rencontrait, on criait. C'était l'euphorie\", se souvient Akli Gasmi, qui n'était alors qu'un jeune berger du village d'Oukhlou, en Kabylie maritime. La population goûte à la liberté retrouvée, les combattants de l'Armée de libération nationale (ALN) paradent dans les rues, les exilés préparent leur retour et les chefs politiques s'apprêtent à endosser le costume de gouvernants. Avec l'indépendance, arrachée après plus de sept années de guerre et la victoire du \"oui\" au référendum du 1er juillet, sonne l'heure de la délivrance.\n" +
                            "\n" +
                            "Pour les combattants de l'ALN, le 5 juillet a concrétisé une victoire acquise depuis la signature des accords d'Evian entre la France et le Gouvernement provisoire de la République algérienne (GPRA), le 18 mars 1962. Dans le pays, le silence du cessez-le-feu a succédé au vacarme des combats, dès le 19 mars 1962 à midi. \"Le fruit de nos sacrifices avait déjà commencé à se traduire au moment du cessez-le-feu. Nous vivions dans l'idée que le pays allait recouvrer sa souveraineté. Pour nous, le 5 juillet annonçait une nouvelle ère\", se remémore le colonel Salim Saadi, alors commandant de la région militaire nord de la frontière algéro-tunisienne. Posté dans la région du Tarf, l'officier n'attendait plus que le feu vert pour implanter ses troupes en Algérie.\n" +
                            "\n" +
                            "Cette attente fiévreuse, le commandant Azzedine, alors à la tête de la Zone autonome d'Alger, ne l'a pas connue. Bien après que l'armée française eut sonné la fin des combats, il a dû mener une autre bataille. Une bataille sanglante contre la \"politique de la terre brûlée\" de l'Organisation armée secrète (OAS) qui, jusqu'aux derniers jours de juin, a multiplié les attentats et les attaques armées pour faire échouer l'abandon inexorable de l'Algérie française. \"Le 5 juillet a été le couronnement de toute une lutte, salue-t-il. L'indépendance, contrairement à ce qui a été dit, ne nous a pas été octroyée. Je suis fier d'appartenir à ce peuple, il a fait une guerre merveilleuse.\"\n"),R.drawable.algerieflag.toString(),R.raw.hymnealgerie.toString()
                    )
                    paysDao.insert(pays)

                    var video = VideoPays(10,1, R.raw.videoplayback.toString())
                    videoDao.insert(video)
                    video = VideoPays(11,1, R.raw.videoplayback1.toString())
                    videoDao.insert(video)






                    image = ImagePays(40,3,R.drawable.algerie1.toString())
                    imageDao.insert(image)
                    image = ImagePays(41,3,R.drawable.algerie2.toString())
                    imageDao.insert(image)
                    image = ImagePays(42,3,R.drawable.algerie3.toString())
                    imageDao.insert(image)
                    image = ImagePays(43,3,R.drawable.algerie4.toString())
                    imageDao.insert(image)
                    image = ImagePays(44,3,R.drawable.algerie5.toString())
                    imageDao.insert(image)
                    image = ImagePays(45,3,R.drawable.algerie6.toString())
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
