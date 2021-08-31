package com.example.course3kotlinmvpbangundatar.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.course3kotlinmvpbangundatar.R
import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ArticlesItem
import com.example.course3kotlinmvpbangundatar.presenter.NewsApiPresenter
import com.example.course3kotlinmvpbangundatar.presenter.NewsApiView

class ReactiveProgrammingActivity : AppCompatActivity(), NewsApiView {
    private var presenter : NewsApiPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reactive_programming)
    }

    override fun onSuccess(msg: String, article: List<ArticlesItem>) {
        TODO("Not yet implemented")
        for (item:ArticlesItem in article){
            Log.d("Data NEWS", item.title.toString())
            Log.d("Data NEWS", item.description.toString())
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this,"Server tidak response", Toast.LENGTH_LONG).show()
    }
}