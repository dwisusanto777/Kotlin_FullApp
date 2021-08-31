package com.example.course3kotlinmvpbangundatar.network

import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ResponseNews
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines?country=id&category=business&apiKey=a85434ead82848caae594b826915712d")
    fun getData(): Call<ResponseNews>

    @GET("top-headlines?")
    fun getNews(
        @Query("country") country:String,
        @Query("category") category:String,
        @Query("apiKey") apiKey:String,
        @Query("pageSize") pageSize:Int,
        @Query("page") page:Long,
    ):Flowable<ResponseNews>
}