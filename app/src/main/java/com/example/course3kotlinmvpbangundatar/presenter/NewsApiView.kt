package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ArticlesItem


interface NewsApiView {

    fun onSuccess(msg:String, article:List<ArticlesItem>)
    fun onError(msg:String)

}