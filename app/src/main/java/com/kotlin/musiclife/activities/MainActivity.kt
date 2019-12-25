package com.kotlin.musiclife.activities

import android.os.Handler
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kotlin.musiclife.R
import com.kotlin.musiclife.base.BaseActivity
import com.kotlin.musiclife.utils.extensions.showToastShort


class MainActivity : BaseActivity() {
    lateinit var navView: BottomNavigationView
    override fun getLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun addControl() {
        navView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        //navView.setupWithNavController(navController)
        navView.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.navigation_library -> {
                    if (navController.currentDestination?.id != R.id.navigation_library) {
                        navController.navigate(R.id.navigation_library)
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    if (navController.currentDestination?.id != R.id.navigation_dashboard) {
                        navController.navigate(R.id.navigation_dashboard)
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    if (navController.currentDestination?.id != R.id.navigation_notifications) {
                        navController.navigate(R.id.navigation_notifications)
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    override fun addEvent() {
    }
    private var isExit = false
    override fun onBackPressed() {
        val navController: NavController = findNavController(R.id.nav_host_fragment)
        if (navController.currentDestination!!.label!! == getString(R.string.title_library)) {

            if (isExit) {
                finish()
                return
            }
            this.isExit = true
            showToastShort(getString(R.string.text_exit_app))
            Handler().postDelayed({ isExit = false }, 500)
        } else {
            navView.selectedItemId = R.id.navigation_library
        }
    }
}
