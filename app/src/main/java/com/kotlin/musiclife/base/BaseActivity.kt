package com.kotlin.musiclife.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.musiclife.R
import com.kotlin.musiclife.utils.extensions.showToastLong

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun getLayoutID(): Int

    protected abstract fun addControl()

    protected abstract fun addEvent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(getLayoutID()>0){
            setContentView(getLayoutID())
            addControl()
            addEvent()
        }else{
            showToastLong(getString(R.string.not_found_activity))
        }
    }

}