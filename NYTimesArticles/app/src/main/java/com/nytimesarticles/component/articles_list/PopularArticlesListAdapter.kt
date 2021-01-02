package com.nytimesarticles.component.articles_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nytimesarticles.R
import com.nytimesarticles.data.models.Article
import com.nytimesarticles.util.OnListItemClickListener
import kotlinx.android.synthetic.main.popular_articles_list_item.view.*

class PopularArticlesListAdapter(
    val articlesList: ArrayList<Article>,
    private val clickListener: OnListItemClickListener<Article>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // actual click listener implementation for a view
    private val mOnClickListener: View.OnClickListener

    init {
        // register the click listener to dispatch the event through the clickListener interface reference
        mOnClickListener = View.OnClickListener { v ->
            // Notify the active callbacks interface that an item has been selected.
            clickListener?.onListItemClick(v.tag as Article)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_articles_list_item, parent, false)
        return ArticlesListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    fun loadMoreItems(list: ArrayList<Article>) {
        articlesList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = articlesList[position]

        with(holder as ArticlesListItemViewHolder) {
            this.articleTitle.text = article.title
            this.articleDesc.text = article.abstract
            this.articleByline.text = article.byline
            if (article.media != null && article.media.isNotEmpty() &&
                article.media[0].media_metadata != null && article.media[0].media_metadata!!.isNotEmpty()
            )
                Glide.with(itemView).load(article.media[0].media_metadata!![2].url)
                    .into(this.articleImage)
            else
                this.articleImage.visibility = View.GONE

            with(itemView) {
                tag = article
                setOnClickListener(mOnClickListener)
            }
        }
    }

    inner class ArticlesListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val articleImage: ImageView = itemView.articleImage
        val articleTitle: TextView = itemView.articleTitle
        val articleDesc: TextView = itemView.articleDescription
        val articleByline: TextView = itemView.articleByline

    }
}
