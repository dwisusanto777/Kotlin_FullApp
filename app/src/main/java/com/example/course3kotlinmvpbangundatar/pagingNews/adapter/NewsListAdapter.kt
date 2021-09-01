package com.example.course3kotlinmvpbangundatar.pagingNews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.course3kotlinmvpbangundatar.R
import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_paging_itemnews.view.*

class NewsListAdapter : PagedListAdapter<ArticlesItem, RecyclerView.ViewHolder>(ArticlesItem().DIFF_CALLBACK) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is NewsHolder){
            holder.bindTo(getItem(position))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_paging_itemnews, parent, false)
        return NewsHolder(view)
    }

    class NewsHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bindTo(item: ArticlesItem?) {
            itemView.item_title.text = item?.title
            itemView.item_desc.text = item?.description
            itemView.item_time.text = item?.publishedAt
            Picasso.get().load(item?.urlToImage).into(itemView.item_image)
        }
    }
}