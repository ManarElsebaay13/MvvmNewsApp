package com.manarelsebaay.mvvmnewsapp.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.manarelsebaay.mvvmnewsapp.R
import com.manarelsebaay.mvvmnewsapp.db.NewsDatabase
import com.manarelsebaay.mvvmnewsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

     lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRepository = NewsRepository(NewsDatabase(this))
        val viewModelProviderFactory = viewModelFactory(newsRepository)

        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)


        val navHostFragment= supportFragmentManager.findFragmentById(R.id.nav_graph_host) as NavHostFragment
        val navController= navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)


    }
}

