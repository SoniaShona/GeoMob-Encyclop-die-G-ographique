package com.example.geomob_encyclopedie_geographique

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import twitter4j.*
import twitter4j.conf.ConfigurationBuilder

class TweetsCountryTab : Fragment() {
    private val myConsumeKey : String= "mabGMqyg1Ol64971cbLMFs2AR"
    private val myConsumerSecret : String="iJxI6pWzZNL80Hy0DjDOFBnqwdZBbMggLHKQnabzEX5M4RVamj"
    private val myAccessToken : String = "1223554396883124224-RpshukHC5gnO1mMoQbcXQibM4R7FrY"
    private val myTokenSecret:String = "s9oBUivHSYHmomZdSgPAvXRJ9mTASzWPHKlneCs6bDifO"
    private var hashtag:String = ""
    private lateinit var paysViewModel: PaysViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tweets_country_tab, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idPays = arguments!!.getInt("idPays")
        paysViewModel = ViewModelProvider(this).get(PaysViewModel::class.java)
        paysViewModel.getPaysById(idPays).observe(viewLifecycleOwner, Observer {pays ->
            hashtag = pays.info.name
            Log.d(ContentValues.TAG,"hashtag "+ hashtag)
            searchTweets(hashtag)
        })
    }

    companion object {
        fun newInstance(): TweetsCountryTab = TweetsCountryTab()
    }

    private fun searchTweets(hashTag:String){
        Log.d(ContentValues.TAG, "hashtag dakhal function "+ hashTag)
        val cb = ConfigurationBuilder()
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey(myConsumeKey)
            .setOAuthConsumerSecret(myConsumerSecret)
            .setOAuthAccessToken(myAccessToken)
            .setOAuthAccessTokenSecret(myTokenSecret)
        val tf = TwitterFactory(cb.build())
        val twitter: Twitter = tf.getInstance()

        GlobalScope.launch {
            try {
                val query = Query("#"+ hashTag)
                Log.d(ContentValues.TAG,"query " + query.toString())
                val result: QueryResult
                result = twitter.search(query)
                val tweets: List<Status> = result.getTweets()
                for (tweet in tweets) {
                    Log.d(ContentValues.TAG,
                        "@" + tweet.getUser().getScreenName().toString() + " - " + tweet.getText()
                    )
                }
            } catch (te: TwitterException) {
                Log.d(ContentValues.TAG,"Failed to search tweets: " + te.errorMessage)
            }
        }
    }

}
