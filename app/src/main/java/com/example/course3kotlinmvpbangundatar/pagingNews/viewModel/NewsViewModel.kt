package com.example.course3kotlinmvpbangundatar.pagingNews.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ArticlesItem
import com.example.course3kotlinmvpbangundatar.pagingNews.datasource.factory.NewsDataFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class NewsViewModel : ViewModel() {
    var executor : Executor
    var articleData : LiveData<PagedList<ArticlesItem>>
    init{
        executor = Executors.newFixedThreadPool(5)
        var newsFactory = NewsDataFactory()
        var pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()
        articleData = LivePagedListBuilder(newsFactory,pageListConfig)
            .setFetchExecutor(executor)
            .build()
    }

    fun getArticel(): LiveData<PagedList<ArticlesItem>>{
        return articleData
    }
}