package com.kotlin.musiclife.utils.extensions

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.kotlin.musiclife.R
import com.kotlin.musiclife.models.TabLibraryClass

fun Activity.showToastShort(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.showToastLong(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun ArrayList<TabLibraryClass>.setItem(context: Context,list: ArrayList<TabLibraryClass>){
    list.add(TabLibraryClass(context.getString(R.string.discover), true))
    list.add(TabLibraryClass(context.getString(R.string.playlist), false))
    list.add(TabLibraryClass(context.getString(R.string.songs), false))
    list.add(TabLibraryClass(context.getString(R.string.genres), false))
}