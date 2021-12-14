package com.alexbirichevskiy.newstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexbirichevskiy.newstest.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit().getRetrofit().create(ApiService::class.java)
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(this)



        val disposable = retrofit.getDataModel()
            .map { it.articles }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { repos, thr ->
                val adapter = RecyclerViewAdapter(repos, object : OnArticleClickListener {
                    override fun onArticleClick(article: Article) {
                        Log.d("@@@@", article.toString())
                        val articleCardFragment = ArticleCardFragment()

                        articleCardFragment.arguments = Bundle().apply {
                            putParcelableArrayList("123", arrayListOf(article))
                        }

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.activity_main_frame_layout_container, articleCardFragment)
                            .addToBackStack("LOL")
                            .commit()
                    }

                })
//                Log.d("@@@@", repos.totalResults.toString())
                binding.newsRecyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
    }
}