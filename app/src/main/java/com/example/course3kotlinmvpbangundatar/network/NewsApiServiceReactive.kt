package com.example.course3kotlinmvpbangundatar.network

import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ResponseNews
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.GET

interface NewsApiServiceReactive {
    @GET("top-headlines?country=id&category=business&apiKey=a85434ead82848caae594b826915712d")
    fun getData(): Flowable<ResponseNews>
}