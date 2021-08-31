package com.example.course3kotlinmvpbangundatar.pagingNews.datasource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ArticlesItem
import com.example.course3kotlinmvpbangundatar.pagingNews.datasource.NewsDataSource

class NewsDataFactory : DataSource.Factory<Long, ArticlesItem>() {
    var mutableLiveData : MutableLiveData<NewsDataSource>
    var newsDataSource : NewsDataSource
    init {
        mutableLiveData = MutableLiveData()
        newsDataSource = NewsDataSource()
    }
    override fun create(): DataSource<Long, ArticlesItem> {
        mutableLiveData.postValue(newsDataSource)
        return newsDataSource
    }

    fun get
}