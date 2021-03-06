package com.alexbirichevskiy.newstest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexbirichevskiy.newstest.Const.SECOND_TAG
import com.alexbirichevskiy.newstest.databinding.FragmentArticleGalleryBinding
import com.bumptech.glide.Glide

class ArticleGalleryFragment : Fragment() {

    private var _binding: FragmentArticleGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString(SECOND_TAG)
        Glide.with(this).load(url).into(binding.articleGalleryImageView)

        binding.galleryFragmentContainer.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}