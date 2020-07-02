package com.example.geomob_encyclopedie_geographique

/*import com.sun.deploy.net.HttpResponse

import sun.net.www.http.HttpClient
import java.io.IOException
import java.net.URISyntaxException


class Tweets {
    //FIXME Replace the keys below with your own keys and secret
    private val CONSUMER_KEY = ""
    private val CONSUMER_SECRET = ""

    /*
   * This method calls the v2 Tweets endpoint with ids as query parameter
   * */
    @Throws(IOException::class, URISyntaxException::class)
    private fun getTweets(ids: String): String? {
        var tweetResponse: String? = null
        val httpClient: HttpClient = HttpClients.custom()
            .setDefaultRequestConfig(
                RequestConfig.custom()
                    .setCookieSpec(CookieSpecs.STANDARD).build()
            )
            .build()
        val uriBuilder = URIBuilder("https://api.twitter.com/labs/2/tweets")
        val queryParameters: ArrayList<NameValuePair>
        queryParameters = ArrayList()
        queryParameters.add(BasicNameValuePair("ids", ids))
        queryParameters.add(BasicNameValuePair("tweet.fields", "created_at"))
        uriBuilder.addParameters(queryParameters)
        val httpGet = HttpGet(uriBuilder.build())
        httpGet.setHeader("Authorization", String.format("Bearer %s", getAccessToken()))
        httpGet.setHeader("Content-Type", "application/json")
        val response: HttpResponse = httpClient.execute(httpGet)
        val entity: HttpEntity = response.getEntity()
        if (null != entity) {
            tweetResponse = EntityUtils.toString(entity, "UTF-8")
        }
        return tweetResponse
    }

    /*
   * Helper method that generates bearer token by calling the /oauth2/token endpoint
   * */
    @Throws(IOException::class, URISyntaxException::class)
    private fun getAccessToken(): String? {
        var accessToken: String? = null
        val httpClient: HttpClient = HttpClients.custom()
            .setDefaultRequestConfig(
                RequestConfig.custom()
                    .setCookieSpec(CookieSpecs.STANDARD).build()
            )
            .build()
        val uriBuilder = URIBuilder("https://api.twitter.com/oauth2/token")
        val postParameters: ArrayList<NameValuePair>
        postParameters = ArrayList()
        postParameters.add(BasicNameValuePair("grant_type", "client_credentials"))
        uriBuilder.addParameters(postParameters)
        val httpPost = HttpPost(uriBuilder.build())
        httpPost.setHeader(
            "Authorization",
            String.format("Basic %s", getBase64EncodedString())
        )
        httpPost.setHeader("Content-Type", "application/json")
        val response: HttpResponse = httpClient.execute(httpPost)
        val entity: HttpEntity = response.getEntity()
        if (null != entity) {
            entity.getContent().use({ inputStream ->
                val mapper = ObjectMapper()
                val jsonMap: Map<String, Any> = mapper.readValue(
                    inputStream,
                    MutableMap::class.java
                )
                accessToken = jsonMap["access_token"].toString()
            })
        }
        return accessToken
    }

    /*
   * Helper method that generates the Base64 encoded string to be used to obtain bearer token
   *
   * */
    private fun getBase64EncodedString(): String? {
        val s = java.lang.String.format("%s:%s", API_KEY, API_SECRET)
        return Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8))
    }
}*/