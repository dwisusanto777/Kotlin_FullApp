package com.example.course3kotlinmvpbangundatar.network

import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ResponseNews
import retrofit2.Call
import retrofit2.http.GET

interface NewsApiService {
    @GET("top-headlines?country=id&category=business&apiKey=a85434ead82848caae594b826915712d")
    fun getData(): Call<ResponseNews>
}