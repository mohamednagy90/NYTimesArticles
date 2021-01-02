package com.nytimesarticles.component.article_details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.nytimesarticles.R
import com.nytimesarticles.data.models.Article
import com.nytimesarticles.util.IntentConst
import kotlinx.android.synthetic.main.activity_article_details.*


class ArticleDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val article: Article? = intent.getParcelableExtra(IntentConst.ArticleObject)
        if (article != null)
            initializeUI(article)
        else {
            finish();
            Toast.makeText(this, resources.getString(R.string.somthingWrong), Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun initializeUI(article: Article) {
        articleTitle.text = article.title
        articleDescription.text = article.abstract
        articleByline.text = article.byline
        if (article.media != null && article.media.isNotEmpty() &&
            article.media[0].media_metadata != null && article.media[0].media_metadata!!.isNotEmpty()
        )
            Glide.with(this).load(article.media[0].media_metadata!![2].url).into(articleImage)
        else
            articleImage.visibility = View.GONE

        if (article.url != null && article.url.isEmpty()) {
            moreDetailsBtn.visibility = View.GONE
        }
        moreDetailsBtn.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
            startActivity(browserIntent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}