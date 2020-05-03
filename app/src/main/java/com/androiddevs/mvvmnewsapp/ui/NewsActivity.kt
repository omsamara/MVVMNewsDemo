package com.androiddevs.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.findFragment
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        bottomNavigationView.setupWithNavController(navHostFragment.navController)

        // If we replaced the FragmentViewContainer with a FrameLayout and a fragment, the code will
        // look like this.

        // bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())

        // This is because newsNavHostFragment.findNavController() relies on the Fragment's View
        // to already be created which isn't the case when using FragmentContainerView
        // (as it uses a FragmentTransaction under the hood to add the NavHostFragment).
        // Therefore, outside of onCreate() we can use findNavController()
    }
}
