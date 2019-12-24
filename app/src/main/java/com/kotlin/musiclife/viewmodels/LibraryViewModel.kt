package com.kotlin.musiclife.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.musiclife.models.TabLibraryClass

class LibraryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text
    val listTabs = MutableLiveData<ArrayList<TabLibraryClass>>()

    fun addListTab(listInput: ArrayList<TabLibraryClass>) {
        listTabs.value = listInput
    }

    fun getListTab(): LiveData<ArrayList<TabLibraryClass>> {
        return listTabs
    }
}