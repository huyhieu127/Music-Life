package com.kotlin.musiclife.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kotlin.musiclife.R
import com.kotlin.musiclife.base.BaseFragment
import com.kotlin.musiclife.viewmodels.HomeViewModel

class HomeFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    override fun addControl() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val textView: TextView = activity!!.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })    }

    override fun addEvent() {
    }


}