package com.manarelsebaay.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.manarelsebaay.mvvmnewsapp.R
import com.manarelsebaay.mvvmnewsapp.model.Article
import com.manarelsebaay.mvvmnewsapp.ui.activities.MainActivity
import com.manarelsebaay.mvvmnewsapp.ui.activities.NewsViewModel
import kotlinx.android.synthetic.main.details_fragment.*

class DetailsFragment : Fragment(R.layout.details_fragment){

     lateinit var viewModel: NewsViewModel
    companion object{  var ARTICLE: Article?=null}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       viewModel = (activity as MainActivity).viewModel

     ARTICLE!!.description?.let {
        details.text= ARTICLE!!.description!!.toString()
     }

        fab.setOnClickListener {
            ARTICLE.let {
                val article:Article= ARTICLE as Article
                viewModel.saveArticle(article)
            }
            Snackbar.make(view,"Article Saved Successfuly ",Snackbar.LENGTH_LONG).show()
        }



}

}