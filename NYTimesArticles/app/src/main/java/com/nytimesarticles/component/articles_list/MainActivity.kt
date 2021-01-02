package com.nytimesarticles.component.articles_list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.nytimesarticles.R
import com.nytimesarticles.component.article_details.ArticleDetailsActivity
import com.nytimesarticles.data.Resource
import com.nytimesarticles.data.models.Article
import com.nytimesarticles.data.models.ArticlesApiResponse
import com.nytimesarticles.util.IntentConst
import com.nytimesarticles.util.OnListItemClickListener
import com.nytimesarticles.util.showSkeleton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnListItemClickListener<Article> {

    private lateinit var popularArticlesViewModel: PopularArticlesViewModel
    private lateinit var skeleton: RecyclerViewSkeletonScreen
    private var popularArticlesResponse: ArticlesApiResponse? = null
    private lateinit var popularArticlesAdapter: PopularArticlesListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = resources.getString(R.string.mostPopularArticles)

        val popularArticlesViewModelFactory =
            PopularArticlesViewModel.PopularArticlesViewModelFactory()
        popularArticlesViewModel = ViewModelProvider(
            this,
            popularArticlesViewModelFactory
        ).get(PopularArticlesViewModel::class.java)

        initializeRecyclerView()
        initializeUI()
        getPopularPeopleList(1)

    }

    private fun initializeUI() {
        todayBtn.setOnClickListener {
            skeleton.show()
            todayBtn.setCardBackgroundColor(resources.getColor(R.color.colorAccent))
            weekBtn.setCardBackgroundColor(resources.getColor(R.color.accentSkeleton))
            monthBtn.setCardBackgroundColor(resources.getColor(R.color.accentSkeleton))
            getPopularPeopleList(1)
        }
        weekBtn.setOnClickListener {
            skeleton.show()
            todayBtn.setCardBackgroundColor(resources.getColor(R.color.accentSkeleton))
            weekBtn.setCardBackgroundColor(resources.getColor(R.color.colorAccent))
            monthBtn.setCardBackgroundColor(resources.getColor(R.color.accentSkeleton))
            getPopularPeopleList(7)
        }
        monthBtn.setOnClickListener {
            skeleton.show()
            todayBtn.setCardBackgroundColor(resources.getColor(R.color.accentSkeleton))
            weekBtn.setCardBackgroundColor(resources.getColor(R.color.accentSkeleton))
            monthBtn.setCardBackgroundColor(resources.getColor(R.color.colorAccent))
            getPopularPeopleList(30)
        }
    }


    private fun initializeRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        popularPeopleRecyclerView.layoutManager = linearLayoutManager
        popularPeopleRecyclerView.setHasFixedSize(true)

        //show skeleton at recycler view until data loaded
        skeleton = popularPeopleRecyclerView.showSkeleton(
            R.layout.skeleton_card_icon_title,
            R.color.white,
            5
        )
        skeleton.show()

    }


    private fun getPopularPeopleList(period: Int) {
        val observable = popularArticlesViewModel.getMostPopularArticles(period)
        observable.observe(this, Observer {

            skeleton.hide() // hide the skeleton
            if (it?.status == Resource.Status.SUCCESS) {
                if (it.data != null) {
                    popularArticlesResponse = it.data
                    val popularArticlesList = popularArticlesResponse?.results
                    if (popularArticlesList != null) {
                        loadPeopleListData(popularArticlesList)
                    }
                } else {
                    Toast.makeText(
                        this,
                        resources.getText(R.string.requestError),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } else if (it?.status == Resource.Status.ERROR) {
                Toast.makeText(this, resources.getText(R.string.requestError), Toast.LENGTH_SHORT)
                    .show()
//                Toast.makeText(this, it.exception?.message.toString() , Toast.LENGTH_SHORT)
//                    .show()

            }
        })
    }

    private fun loadPeopleListData(popularPeopleList: ArrayList<Article>) {
        if (popularPeopleList != null && popularPeopleList.size > 0) {

            popularArticlesAdapter = PopularArticlesListAdapter(popularPeopleList, this)
            popularPeopleRecyclerView.adapter = popularArticlesAdapter

        } else {
            Toast.makeText(this, "No Popular Articles to show", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onListItemClick(item: Article?) {
        val intent = Intent(this, ArticleDetailsActivity::class.java)
        intent.putExtra(IntentConst.ArticleObject, item)
        startActivity(intent)
    }


}
