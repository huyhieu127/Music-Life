package com.kotlin.musiclife.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.musiclife.R
import com.kotlin.musiclife.base.BaseFragment

class PlaylistFragment : BaseFragment() {
    override fun getLayoutID(): Int {
        return R.layout.fragment_playlist
    }

    override fun addControl(view: View) {
    }

    override fun addEvent(view: View) {
    }
}
