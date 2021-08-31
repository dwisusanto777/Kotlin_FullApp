package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ArticlesItem
import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ResponseNews
import com.example.course3kotlinmvpbangundatar.network.NewsApiService
import com.example.course3kotlinwisataaplikasi.retrofitconfig.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsApiPresenter(val news : NewsApiView) {

    fun getNews() {
        var service = RetrofitInstance.getInstance("https://newsapi.org/v2/").create(NewsApiService::class.java)
        service.getData().enqueue(object : Callback<ResponseNews> {
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                TODO("Not yet implemented")
                if(response.isSuccessful){
                    val dataNews = response.body()?.articles
                    if(dataNews?.size?:0>0){
                        news.onSuccess(response.message(), dataNews as List<ArticlesItem>)
                    }else{

                    }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                news.onError(t.localizedMessage)
            }
        })
    }

}