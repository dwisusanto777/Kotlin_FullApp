package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ArticlesItem
import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ResponseNews
import com.example.course3kotlinmvpbangundatar.network.NewsApiService
import com.example.course3kotlinmvpbangundatar.network.NewsApiServiceReactive
import com.example.course3kotlinwisataaplikasi.retrofitconfig.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsReactiveApiPresenter(val news : NewsApiView) {

    fun getNews() {
        // menggunakan codingan reactive
        var service = RetrofitInstance.getInstanceReactvice("https://newsapi.org/v2/").create(NewsApiServiceReactive::class.java)
        service.getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    response ->
                if(response.totalResults==200){
                    news.onSuccess(response.status ?: "", response.articles as List<ArticlesItem>)
                }
            },{
                    e ->
                news.onError(e.localizedMessage)
            })


//        var service = RetrofitInstance.getInstance("https://newsapi.org/v2/").create(NewsApiService::class.java)
//        service.getData().enqueue(object : Callback<ResponseNews> {
//            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
//                TODO("Not yet implemented")
//                if(response.isSuccessful){
//                    val dataNews = response.body()?.articles
//                    if(dataNews?.size?:0>0){
//                        news.onSuccess(response.message(), dataNews as List<ArticlesItem>)
//                    }else{
//
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
//                news.onError(t.localizedMessage)
//            }
//        })


    }

}