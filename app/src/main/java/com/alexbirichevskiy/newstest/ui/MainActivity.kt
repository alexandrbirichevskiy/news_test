package com.alexbirichevskiy.newstest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexbirichevskiy.newstest.App
import com.alexbirichevskiy.newstest.OnArticleClickListener
import com.alexbirichevskiy.newstest.R
import com.alexbirichevskiy.newstest.RecyclerViewAdapter
import com.alexbirichevskiy.newstest.databinding.ActivityMainBinding
import com.alexbirichevskiy.newstest.domain.entities.Article
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private val adapter: RecyclerViewAdapter by lazy { RecyclerViewAdapter(OnArticleClickListener) }
    private val OnArticleClickListener: OnArticleClickListener =
        object : OnArticleClickListener {
            override fun onArticleClick(article: Article) {
                val fragment = createFragment(article)
                openFragment(fragment)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("@@@@", "OnCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.loadData()
        viewModel.data.observe(this, Observer {
            adapter.setData(it.reversed())
        })

        binding.newsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.newsRecyclerView.adapter = adapter

        binding.swipeToRefresh.setOnRefreshListener {
            refreshData()
        }
    }

    fun openFragment(articleCardFragment: ArticleCardFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_main_frame_layout_container, articleCardFragment)
            .addToBackStack("LOL")
            .commit()
    }

    fun createFragment(article: Article): ArticleCardFragment {
        val articleCardFragment = ArticleCardFragment()

        articleCardFragment.arguments = Bundle().apply {
            putParcelableArrayList("123", arrayListOf(article))
        }
        return articleCardFragment
    }

    fun refreshData() {
        binding.swipeToRefresh.isRefreshing = true
        viewModel.loadData()
        binding.swipeToRefresh.isRefreshing = false
    }
}