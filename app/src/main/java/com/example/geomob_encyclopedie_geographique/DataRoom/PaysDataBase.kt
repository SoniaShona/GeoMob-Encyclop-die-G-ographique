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

                    // Add countries


                    // USA
                    var pays =Pays(1,
                        Info("USA","","9 833 517 km2","328 239 523 hab", "4 juillet 1776",
                            "La Déclaration unanime des treize États unis d’Amérique1 (en anglais : The unanimous declaration of the thirteen united States of America), généralement appelée « Déclaration d'indépendance des États-Unis d'Amérique », est un texte politique par lequel les treize colonies britanniques d'Amérique du Nord ont fait sécession de la Grande-Bretagne le 4 juillet 1776, pour former les « États-Unis d'Amérique ». Ce texte est marqué par l'influence de la philosophie des Lumières et tire également les conséquences de la Révolution anglaise de 1688 : d'après les abus constatés, les délégués des colons estiment qu'ils ont le droit et le devoir de se révolter contre la monarchie britannique (en fait, le Parlement britannique a voté de lourds impôts et taxes frappant les colonies). Depuis, le 4 juillet est devenu la fête nationale des États-Unis : l'Independence Day (« Jour de l'Indépendance » en français).\n" +
                                "\n" +
                                "Depuis 2005, elle est classée sur la Liste Mémoire du monde de l'UNESCO."),R.drawable.usaflag.toString(),R.raw.hymneusa.toString(),false
                    )
                    paysDao.insert(pays)

                    var image = ImagePays(10,1,R.drawable.usa3.toString())
                    imageDao.insert(image)
                    image = ImagePays(11,1,R.drawable.usa1.toString())
                    imageDao.insert(image)
                    image = ImagePays(12,1,R.drawable.usa2.toString())
                    imageDao.insert(image)
                    image = ImagePays(13,1,R.drawable.usa4.toString())
                    imageDao.insert(image)
                    image = ImagePays(14,1,R.drawable.usa5.toString())
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


                    var video = VideoPays(10,1, "https://www.youtube.com/watch?v=qOd-MSLDick")
                    videoDao.insert(video)
                    video = VideoPays(11,1, "https://www.youtube.com/watch?v=_iXaD76lhGg")
                    videoDao.insert(video)




                    /*****************************************************************************************************************************/
                    //France
                    pays = Pays(2,
                        Info("France","","632 734 KM2","67 848 156 hab.", "14 juillet 1789","La prise de la Bastille, survenue le mardi 14 juillet 1789 à Paris, est l'un des événements inauguraux et emblématiques de la Révolution française. Cette journée, durant laquelle la Bastille est prise d’assaut par des émeutiers, est, dans la tradition historiographique, considérée comme la première intervention d'ampleur du peuple parisien dans le cours de la Révolution et dans la vie politique française."),R.drawable.franceflag.toString(),R.raw.hymnefrance.toString(),true
                    )
                    paysDao.insert(pays)


                    image = ImagePays(20,2,R.drawable.france1.toString())
                    imageDao.insert(image)
                    image = ImagePays(21,2,R.drawable.france2.toString())
                    imageDao.insert(image)
                    image = ImagePays(22,2,R.drawable.france3.toString())
                    imageDao.insert(image)
                    image = ImagePays(23,2,R.drawable.france4.toString())
                    imageDao.insert(image)


                    personnalite = Personnalite(20,2,"Emmanuel Macron",R.drawable.macron.toString(),"Emmanuel Macron, né le 21 décembre 1977 à Amiens, est un haut fonctionnaire, banquier d'affaires et homme d'État français. Il est président de la République française depuis le 14 mai 2017. Sorti de l'École nationale d'administration en 2004, il devient inspecteur des finances.")
                    personnaliteDao.insert(personnalite)


                    ressource = Ressource(20,2,"Tour Eifel",R.drawable.franceressource1.toString(),"La tour Eiffel est une tour de fer puddlé de 324 mètres de hauteur située à Paris, à l’extrémité nord-ouest du parc du Champ-de-Mars en bordure de la Seine dans le 7ᵉ arrondissement. Son adresse officielle est 5, avenue Anatole-France")
                    ressourceDao.insert(ressource)
                    ressource = Ressource(21,2,"Musée du Louvre",R.drawable.franceressource2.toString(),"Le musée du Louvre est un musée situé à Paris, en France. Une préfiguration en est imaginée en 1775-1776 par le comte d'Angivillier, directeur général des Bâtiments du roi, comme lieu de présentation des chefs-d'œuvre de la collection de la Couronne.")
                    ressourceDao.insert(ressource)
                    ressource = Ressource(22,2,"Disneyland Paris",R.drawable.franceressource3.toString(),"Disneyland Paris, anciennement Euro Disney Resort puis Disneyland Resort Paris, est un complexe touristique et urbain de 22,30 km² situé en sa majeure partie dans la commune de Chessy, à trente-deux kilomètres à l'est de Paris.")
                    ressourceDao.insert(ressource)




                    video = VideoPays(20,2,"https://www.youtube.com/watch?v=oVU7ybbCcQc")
                    videoDao.insert(video)
                    video = VideoPays(21,2,"https://www.youtube.com/watch?v=nnQJOdUY1FM")
                    videoDao.insert(video)









                    /*****************************************************************************************************************************/
                    //Algérie
                    pays = Pays(3, Info("Algérie","L'Algérie est un pays nord-africain doté d'un littoral sur la mer Méditerranée et d'un intérieur désertique, le Sahara. De nombreux empires y ont laissé leur marque, comme les anciennes ruines romaines de Tipasa, en bord de mer. Dans la capitale, Alger, des sites ottomans, tels que la mosquée Ketchaoua, datant de 1612 environ, bordent le quartier de la Casbah. Perché sur une colline, cet endroit dispose d'allées étroites et d'escaliers. La basilique Notre-Dame d'Afrique, arborant une architecture néo-byzantine, date de la domination coloniale française.","2 381 741 KM2","42 972 878 hab.","5 juillet 1962","C'est un jour qui ne ressemble à aucun autre. En ce 5 juillet 1962, l'Algérie fête, dans la frénésie, l'indépendance que doit proclamer le soir même le général de Gaulle. Cent trente-deux ans jour pour jour après la prise d'Alger par les Français. Hommes, femmes et enfants défilent dans les rues, au cri de \"Vive l'Algérie indépendante\", vêtus de leurs habits de fête, drapeaux du Front de libération nationale (FLN) au vent.\n" +
                            "\n" +
                            "\"C'est quelque chose qu'on ne vit qu'une fois. On a vu tous les villages, toute la population venir, les hommes, les femmes. Ils dansaient, ils chantaient. On se rencontrait, on criait. C'était l'euphorie\", se souvient Akli Gasmi, qui n'était alors qu'un jeune berger du village d'Oukhlou, en Kabylie maritime. La population goûte à la liberté retrouvée, les combattants de l'Armée de libération nationale (ALN) paradent dans les rues, les exilés préparent leur retour et les chefs politiques s'apprêtent à endosser le costume de gouvernants. Avec l'indépendance, arrachée après plus de sept années de guerre et la victoire du \"oui\" au référendum du 1er juillet, sonne l'heure de la délivrance.\n" +
                            "\n" +
                            "Pour les combattants de l'ALN, le 5 juillet a concrétisé une victoire acquise depuis la signature des accords d'Evian entre la France et le Gouvernement provisoire de la République algérienne (GPRA), le 18 mars 1962. Dans le pays, le silence du cessez-le-feu a succédé au vacarme des combats, dès le 19 mars 1962 à midi. \"Le fruit de nos sacrifices avait déjà commencé à se traduire au moment du cessez-le-feu. Nous vivions dans l'idée que le pays allait recouvrer sa souveraineté. Pour nous, le 5 juillet annonçait une nouvelle ère\", se remémore le colonel Salim Saadi, alors commandant de la région militaire nord de la frontière algéro-tunisienne. Posté dans la région du Tarf, l'officier n'attendait plus que le feu vert pour implanter ses troupes en Algérie.\n" +
                            "\n" +
                            "Cette attente fiévreuse, le commandant Azzedine, alors à la tête de la Zone autonome d'Alger, ne l'a pas connue. Bien après que l'armée française eut sonné la fin des combats, il a dû mener une autre bataille. Une bataille sanglante contre la \"politique de la terre brûlée\" de l'Organisation armée secrète (OAS) qui, jusqu'aux derniers jours de juin, a multiplié les attentats et les attaques armées pour faire échouer l'abandon inexorable de l'Algérie française. \"Le 5 juillet a été le couronnement de toute une lutte, salue-t-il. L'indépendance, contrairement à ce qui a été dit, ne nous a pas été octroyée. Je suis fier d'appartenir à ce peuple, il a fait une guerre merveilleuse.\"\n"),R.drawable.algerieflag.toString(),R.raw.hymnealgerie.toString(),false
                    )
                    paysDao.insert(pays)




                    image = ImagePays(30,3,R.drawable.algerie1.toString())
                    imageDao.insert(image)
                    image = ImagePays(31,3,R.drawable.algerie2.toString())
                    imageDao.insert(image)
                    image = ImagePays(32,3,R.drawable.algerie3.toString())
                    imageDao.insert(image)
                    image = ImagePays(33,3,R.drawable.algerie4.toString())
                    imageDao.insert(image)
                    image = ImagePays(34,3,R.drawable.algerie5.toString())
                    imageDao.insert(image)
                    image = ImagePays(35,3,R.drawable.algerie6.toString())
                    imageDao.insert(image)



                    personnalite = Personnalite(30,3,"Abdelmadjid Tebboune" , R.drawable.tebboun.toString(),"Abdelmadjid Tebboune, né le 17 novembre 1945 à Méchria, est un homme d'État algérien. Il est président de la République algérienne démocratique et populaire depuis le 19 décembre 2019")
                    personnaliteDao.insert(personnalite)
                    personnalite = Personnalite(31,3,"Ahmed Gaïd Salah",R.drawable.gaidsalah.toString(),"Ahmed Gaïd Salah, né le 13 janvier 1940 à Aïn Yagout dans l'actuelle wilaya de Batna et mort le 23 décembre 2019, est un officier général et homme d'État algérien. De 2004 à son décès, il exerce la fonction de chef d'État-Major au sein de l'Armée nationale populaire")
                    personnaliteDao.insert(personnalite)

                    ressource = Ressource(30,3,"Mémorial du Martyr",R.drawable.algerieressource1.toString(),"Le mémorial du Martyr, sanctuaire du Martyr ou Maqam E’chahid est un monument aux morts surplombant la ville d'Alger, érigé en 1982 à l'occasion du 20ᵉ anniversaire de l'indépendance de l'Algérie.")
                    ressourceDao.insert(ressource)
                    ressource = Ressource(31,3,"Hoggar",R.drawable.algerieressource2.toString(),"Le Hoggar est un massif montagneux qui s'élève à 2 918 m d'altitude dans le Sud de l'Algérie, au cœur du Sahara")
                    ressourceDao.insert(ressource)

                    video = VideoPays(30,3,"https://www.youtube.com/watch?v=B9wceXZIe0U")
                    videoDao.insert(video)



                    /*****************************************************************************************************************************/
                    //Royaume Uni
                    pays = Pays(4,Info("Royaume-Uni","","246 690 km2","65 761 117 hab","1927","Les royaumes d'Angleterre et d'Écosse ont cohabité en tant que nations souveraines et indépendantes avec leurs propres monarques et structures politiques depuis le ixe siècle. La Principauté de Galles est intégrée au Royaume d'Angleterre en 1536, après son annexion à la suite du Statut de Rhuddlan en 1284. L'Irlande, conquise à partir du xiie siècle, est un royaume indépendant mais en 1541, Henri VIII devient roi d'Irlande. À partir de l'Union des Couronnes en 1603, le Royaume d'Écosse partage également le même souverain, mais Angleterre, Écosse et Irlande restent des États distincts. Durant l'interrègne anglais, le Commonwealth d'Angleterre annexe l'Écosse et l'Irlande, mais la situation précédente est restaurée avec la royauté en 1660. La Révolution financière britannique et le développement d'une presse indépendante et de très nombreuses sociétés par action renforcent l'économie anglaise, tandis que l'effondrement de la Compagnie du Darién du financier écossais William Paterson engloutit les économies des Écossais et suscite une grave crise financière. Celle-ci débouche sur les Actes d'Union (1707), à travers lesquels l'Angleterre (incluant le pays de Galles) et l'Écosse deviennent une union politique sous la forme du royaume de Grande-Bretagne. L'Acte d'Union de 1800 a unifié le royaume de Grande-Bretagne et le Royaume d'Irlande, qui est lentement tombé sous contrôle anglais entre 1541 et 1691, pour former le Royaume-Uni de Grande-Bretagne et d'Irlande en 1801. L'indépendance de l'État libre d'Irlande en 1922 a suivi la séparation de l'île d'Irlande deux ans auparavant avec six des neuf comtés de la province d'Ulster restant attachés au Royaume-Uni, ce qui mène donc en 1927 au nom officiel actuel de « Royaume-Uni de Grande-Bretagne et d'Irlande du Nord ». Le Royaume-Uni est donc une union de quatre nations (Angleterre, Écosse, pays de Galles et Irlande du Nord)."),
                    R.drawable.royaumeuniflag.toString(),R.raw.hymneroyaumeuni.toString(),false)
                    paysDao.insert(pays)


                    image = ImagePays(40,4,R.drawable.royaumeuni1.toString())
                    imageDao.insert(image)
                    image = ImagePays(41,4,R.drawable.royaumeuni2.toString())
                    imageDao.insert(image)
                    image = ImagePays(42,4,R.drawable.royaumeuni3.toString())
                    imageDao.insert(image)
                    image = ImagePays(43,4,R.drawable.royaumeuni4.toString())
                    imageDao.insert(image)
                    image = ImagePays(44,4,R.drawable.royaumeuni5.toString())
                    imageDao.insert(image)


                    personnalite = Personnalite(40,4,"Élisabeth II",R.drawable.elisabeth.toString(),"Élisabeth II, née le 21 avril 1926 à Londres, est la reine du Royaume-Uni de Grande-Bretagne et d'Irlande du Nord ainsi que de quinze autres États souverains, appelés royaumes du Commonwealth, et de leurs territoires et dépendances")
                    personnaliteDao.insert(personnalite)


                    ressource = Ressource(40,4,"Big Ben",R.drawable.royaumeuniressource1.toString(),"Big Ben est le surnom de la grande cloche de 13,5 tonnes se trouvant au sommet de la tour Élisabeth (Elizabeth Tower), la tour horloge du palais de Westminster, qui est le siège du Parlement britannique (Houses of Parliament), à Londres.")
                    ressourceDao.insert(ressource)

                    video = VideoPays(40,4,"https://www.youtube.com/watch?v=qddlrokZsF8")
                    videoDao.insert(video)
                    video = VideoPays(40,4,"https://www.youtube.com/watch?v=fUo5bqnJvbg")
                    videoDao.insert(video)


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
