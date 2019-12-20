package com.kotlin.musiclife.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
            Toast.makeText(this,"Layout error", Toast.LENGTH_SHORT).show()
        }
    }
}