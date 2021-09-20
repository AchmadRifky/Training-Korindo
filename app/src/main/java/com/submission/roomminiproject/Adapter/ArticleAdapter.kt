package com.submission.roomminiproject.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.submission.roomminiproject.ArticleAddUpdateActivity
import com.submission.roomminiproject.Helper.ArticleDiffCallback
import com.submission.roomminiproject.Model.Article
import com.submission.roomminiproject.databinding.ItemArticleBinding


class ArticleAdapter internal constructor(private val activity: Activity): RecyclerView.Adapter<ArticleAdapter.myViewHolder>(){

    private val listArticle= ArrayList<Article>()

    inner class myViewHolder(private val binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            with(binding) {
                tvItemTitle.text = article.title
                tvItemDescription.text = article.description
                cvItemNote.setOnClickListener {
                    val intent = Intent(activity, ArticleAddUpdateActivity::class.java)
                    intent.putExtra(ArticleAddUpdateActivity.EXTRA_POSITION, adapterPosition)
                    intent.putExtra(ArticleAddUpdateActivity.EXTRA_NOTE, article)
                    activity.startActivityForResult(intent, ArticleAddUpdateActivity.REQUEST_UPDATE)

//                    EventBus.getDefault().post(article)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myViewHolder(binding)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(listArticle[position])
    }

    override fun getItemCount(): Int {
        return listArticle.size
    }

    fun setListArticle(listArticle: List<Article>) {
        val diffResult = DiffUtil.calculateDiff(ArticleDiffCallback(this.listArticle, listArticle))
        this.listArticle.clear()
        this.listArticle.addAll(listArticle)
        diffResult.dispatchUpdatesTo(this)
    }
}