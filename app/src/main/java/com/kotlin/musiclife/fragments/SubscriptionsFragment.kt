package com.kotlin.musiclife.fragments

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kotlin.musiclife.R
import com.kotlin.musiclife.base.BaseFragment
import com.kotlin.musiclife.utils.extensions.showToastShort
import com.kotlin.musiclife.viewmodels.SubscriptionsViewModel
import kotlinx.android.synthetic.main.fragment_subscriptions.*

class SubscriptionsFragment : BaseFragment() {

    private lateinit var subscriptionsViewModel: SubscriptionsViewModel
    override fun getLayoutID(): Int {
        return R.layout.fragment_subscriptions
    }

    override fun addControl() {
        subscriptionsViewModel = ViewModelProviders.of(this).get(SubscriptionsViewModel::class.java)
        subscriptionsViewModel.text.observe(this, Observer {
            text_home.text = it
        })
    }

    override fun addEvent() {
    }

    override fun onBackFragment() {
        mActivity.showToastShort(getString(R.string.text_exit_app))
    }
}