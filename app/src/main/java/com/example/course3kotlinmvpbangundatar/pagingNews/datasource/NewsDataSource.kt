package com.example.course3kotlinmvpbangundatar.pagingNews.datasource

import androidx.paging.PageKeyedDataSource
import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ArticlesItem
import com.example.course3kotlinmvpbangundatar.network.NewsApiService
import com.example.course3kotlinwisataaplikasi.retrofitconfig.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsDataSource : PageKeyedDataSource<Long, ArticlesItem>() {

    var api:NewsApiService
    init {
        api = RetrofitInstance.getInstance("https://newsapi.org/v2/").create(NewsApiService::class.java)
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ArticlesItem>
    ) {
        //country=id&category=business&apiKey=a85434ead82848caae594b826915712d&pageSize=30&page=2
        api.getNews("id","business", "a85434ead82848caae594b826915712d", params.requestedLoadSize, 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    response ->
                callback.onResult(response.articles as List<ArticlesItem>, null, 2L)
//                news.onSuccess(response.status ?: "", response.articles as List<ArticlesItem>)
            },{
                    e ->
//                news.onError(e.localizedMessage)
            })
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ArticlesItem>) {
        api.getNews("id","business", "a85434ead82848caae594b826915712d", params.requestedLoadSize, params.key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    response ->
                callback.onResult(response.articles as List<ArticlesItem>, params.key+1)
//                news.onSuccess(response.status ?: "", response.articles as List<ArticlesItem>)
            },{
                    e ->
//                news.onError(e.localizedMessage)
            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ArticlesItem>) {
    }

}