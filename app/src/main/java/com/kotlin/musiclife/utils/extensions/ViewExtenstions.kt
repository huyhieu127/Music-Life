package com.kotlin.musiclife.utils.extensions

import android.app.Activity
import android.widget.Toast
import com.kotlin.musiclife.models.TabLibraryClass

fun Activity.showToastShort(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.showToastLong(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun ArrayList<TabLibraryClass>.setItem(list: ArrayList<TabLibraryClass>){
    list.add(TabLibraryClass("Discover", true))
    list.add(TabLibraryClass("Playlist", false))
    list.add(TabLibraryClass("Songs", false))
    list.add(TabLibraryClass("Genres", false))
}