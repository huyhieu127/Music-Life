package com.kotlin.musiclife.utils.extensions

import android.app.Activity
import android.widget.Toast

fun Activity.showToastShort(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.showToastLong(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}