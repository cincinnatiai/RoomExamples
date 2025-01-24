package com.hehc.roomsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hehc.roomsample.di.DependencyInjectionModule
import com.hehc.roomsample.ui.homescreen.HomeFragment
import com.hehc.roomsample.ui.savedships.PreferencesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBaseView()
        replaceFragment(HomeFragment())
        setupBottomBarNavigation()
        DependencyInjectionModule.initialize(this)
    }

    private fun setupBottomBarNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_bar)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.network -> replaceFragment(HomeFragment())
                R.id.local -> replaceFragment(PreferencesFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun setupBaseView() {
        setContentView(R.layout.activity_main)
    }
}
