package com.sleeplessdog.matchthewords.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.sleeplessdog.matchthewords.R
import com.sleeplessdog.matchthewords.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setupWithNavController(navController)
    }
}