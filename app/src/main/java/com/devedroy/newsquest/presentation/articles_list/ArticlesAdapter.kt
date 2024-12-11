package com.devedroy.newsquest.presentation.articles_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devedroy.newsquest.databinding.ArticleItemViewBinding
import com.devedroy.newsquest.domain.models.Article
import com.devedroy.newsquest.presentation.extensions.loadImage

class ArticlesAdapter(
    private val articles: List<Article>
) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ArticleItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    inner class ArticleViewHolder(private val binding: ArticleItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.tvTitle.text = article.title
            binding.tvAuthor.text = article.author
            binding.tvDescription.text = article.description
            binding.tvPublishedDate.text = article.publishedDate
            article.urlToImage?.let {
                binding.ivArticle.loadImage(it)
            }
        }
    }
}