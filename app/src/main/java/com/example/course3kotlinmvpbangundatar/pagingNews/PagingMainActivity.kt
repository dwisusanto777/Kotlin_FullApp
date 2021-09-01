package com.example.course3kotlinmvpbangundatar.pagingNews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.course3kotlinmvpbangundatar.R
import com.example.course3kotlinmvpbangundatar.pagingNews.adapter.NewsListAdapter
import com.example.course3kotlinmvpbangundatar.pagingNews.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.activity_paging_main.*

class PagingMainActivity : AppCompatActivity() {
    private var viewModel:NewsViewModel ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging_main)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel?.getArticel()?.observe(this, Observer {
            val adapter = NewsListAdapter()
            adapter.submitList(it)
            listNews.adapter = adapter
        })
    }
}