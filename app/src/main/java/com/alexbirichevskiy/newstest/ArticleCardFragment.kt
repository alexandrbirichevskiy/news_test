package com.alexbirichevskiy.newstest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexbirichevskiy.newstest.databinding.FragmentArticleCardBinding
import com.bumptech.glide.Glide

class ArticleCardFragment : Fragment() {

    private var _binding: FragmentArticleCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list: List<Article> = arguments?.getParcelableArrayList("123")!!
        val myData = list[0]
        binding.articleCardAuthorTextView.text = myData.author
        binding.articleCardDescriptionTextView.text = myData.description
        binding.articleCardPublishedAtTextView.text = myData.publishedAt
        binding.articleCardTitleTextView.text = myData.title
        binding.articleCardUrlTextView.text = myData.url

        Glide.with(this).load(myData.urlToImage).into(binding.articleCardImageView)

        binding.articleCardImageView.setOnClickListener {
            val articleGalleryFragment = ArticleGalleryFragment()

            articleGalleryFragment.arguments = Bundle().apply {
                putString("456", myData.urlToImage)
            }

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.activity_main_frame_layout_container, articleGalleryFragment)
                ?.addToBackStack("Lol1")
                ?.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}