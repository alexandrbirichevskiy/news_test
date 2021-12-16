package com.alexbirichevskiy.newstest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexbirichevskiy.newstest.domain.entities.Article
import com.bumptech.glide.Glide

class RecyclerViewAdapter(
    private val onArticleClickListener: OnArticleClickListener
) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var articles: List<Article> = arrayListOf()

    fun setData(articles: List<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val recyclerViewHolder = RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )

        recyclerViewHolder.itemView.setOnClickListener {
            val article: Article = articles.get(recyclerViewHolder.adapterPosition)
            onArticleClickListener.onArticleClick(article)
        }

        return recyclerViewHolder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(articles.get(position))
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}

class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(article: Article) {
        itemView.findViewById<TextView>(R.id.title_text_view).text = article.title.toString()
        Glide.with(itemView.context).load(article.urlToImage)
            .into(itemView.findViewById(R.id.image_view))
    }
}

interface OnArticleClickListener {
    fun onArticleClick(article: Article)
}