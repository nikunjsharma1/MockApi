package com.nikunj.mockapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nikunj.mockapp.R

class MainActivity : AppCompatActivity() {

    lateinit var navController : NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var bottomBar : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Bottom nav view*/
        bottomBar = findViewById(R.id.bottom_navigation)
       // navController = findNavController(R.id.fragment)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        bottomBar.setupWithNavController(navController)

        /** App Bar changes as Fragment changes */
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.savedFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}