package com.example.course3kotlinmvpbangundatar.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RestApi {

    fun restApi(baseUrl:String):NewsApiService{
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttp = OkHttpClient().newBuilder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create() )
            .client(okHttp)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();
        return retrofit.create(NewsApiService::class.java)
    }

}