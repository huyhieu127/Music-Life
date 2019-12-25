package com.kotlin.musiclife.base

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kotlin.musiclife.R
import com.kotlin.musiclife.utils.extensions.showToastLong
import com.kotlin.musiclife.utils.extensions.showToastShort

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun getLayoutID(): Int

    protected abstract fun addControl()

    protected abstract fun addEvent()

    val bottomNavigationView: BottomNavigationView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutID() > 0) {
            setContentView(getLayoutID())
            addControl()
            addEvent()
        } else {
            showToastLong(getString(R.string.not_found_activity))
        }
    }
}