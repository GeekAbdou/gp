package com.example.booksaplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.booksaplicationkotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        binding.bottomNavigationMenu.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            binding.bottomNavigationMenu.isVisible = when (destination.id) {
                R.id.loginFragment , R.id.registrationFragment-> false
                else -> true
            }
        }
    }

}