package com.example.retrofitexample
import com.google.gson.Gson
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import android.telecom.Call as Call1


// https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=861cd7d5eeda4ac4a616c61ef396f29d
// https://newsapi.org/v2/everything?q=apple&from=2024-04-03&to=2024-04-03&sortBy=popularity&apiKey=861cd7d5eeda4ac4a616c61ef396f29d

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "861cd7d5eeda4ac4a616c61ef396f29d"

interface NewsInterface {
    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<News>

    //https://newsapi.org/v2/top-headlines?apiKey=861cd7d5eeda4ac4a616c61ef396f29d&country=in&page=1
}

object NewsService{
    val newsInstance: NewsInterface
    init{
        val retrofit :Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
