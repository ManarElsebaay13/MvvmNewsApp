package com.manarelsebaay.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.manarelsebaay.mvvmnewsapp.R
import com.manarelsebaay.mvvmnewsapp.ui.adapters.NewsAdapter
import com.manarelsebaay.mvvmnewsapp.ui.activities.MainActivity
import com.manarelsebaay.mvvmnewsapp.ui.activities.NewsViewModel
import kotlinx.android.synthetic.main.search_fragment.*

class BookMarkedFragment : Fragment (R.layout.bookmarked_fragment) {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

     val TAG = "BookMarkedFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()
        newsAdapter.setOnItemClickListener {
            DetailsFragment.ARTICLE =it
            findNavController().navigate(R.id.action_bookMarkedFragment_to_detailsFragment)
        }

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                    ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return  true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = newsAdapter.differ.currentList[position]
                viewModel.deletArticle(article)
                Snackbar.make(view,"Article deleted successfully ",Snackbar.LENGTH_LONG).apply {
                    setAction("undo"){
                        viewModel.saveArticle(article)
                    }
                }.show()

            } }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(search_rv)
        }

        viewModel.getArticles().observe(viewLifecycleOwner,Observer{
            newsAdapter.differ.submitList(it)
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
        search_rv.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }




}