package com.manarelsebaay.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.manarelsebaay.mvvmnewsapp.ui.activities.MainActivity
import com.manarelsebaay.mvvmnewsapp.R
import com.manarelsebaay.mvvmnewsapp.adapters.NewsAdapter
import com.manarelsebaay.mvvmnewsapp.utils.Resource
import com.manarelsebaay.mvvmnewsapp.ui.activities.NewsViewModel
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment :Fragment (R.layout.home_fragment){

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "NewsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply{
                putSerializable("article",it)
        }
        findNavController().navigate(
            R.id.action_homeFragment_to_detailsFragment,
            bundle
        )

        }


        viewModel.EgyptNews.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }
    private fun hideProgressBar() {
        ProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        ProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        egyptNews_rv.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


}