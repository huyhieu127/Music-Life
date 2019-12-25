package com.kotlin.musiclife.fragments

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.musiclife.R
import com.kotlin.musiclife.adapters.TabLibraryAdapter
import com.kotlin.musiclife.adapters.TabLibraryAdapter.OnClickItemListener
import com.kotlin.musiclife.base.BaseFragment
import com.kotlin.musiclife.models.TabLibraryClass
import com.kotlin.musiclife.utils.commons.StartSnapHelper
import com.kotlin.musiclife.utils.extensions.setItem
import com.kotlin.musiclife.utils.extensions.showToastLong
import com.kotlin.musiclife.utils.extensions.showToastShort
import com.kotlin.musiclife.viewmodels.LibraryViewModel


class LibraryFragment : BaseFragment() {

    private lateinit var libraryViewModel: LibraryViewModel
    lateinit var list: ArrayList<TabLibraryClass>
    lateinit var rcv: RecyclerView
    lateinit var navController:NavController

    override fun getLayoutID(): Int {
        return R.layout.fragment_library
    }

    override fun addControl(view: View) {
        initFragment(view)
        handleViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rcv.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false)
        rcv.setHasFixedSize(true)
        val adapter = TabLibraryAdapter(mActivity, list)
        rcv.adapter = adapter
        adapter.setOnClickItemListener(object : OnClickItemListener {
            override fun onClick(position: Int) {
                if (position > 1) {
                    rcv.smoothScrollToPosition(adapter.itemCount)
                } else {
                    rcv.smoothScrollToPosition(0)
                }
                chooseTab(position)
            }
        })
        /*Auto move item focus to center*/
        StartSnapHelper().attachToRecyclerView(rcv)
    }

    private fun chooseTab(position: Int) {
        when(position){
            0 -> navController.navigate(R.id.discoverFragment)
            1 -> navController.navigate(R.id.playlistFragment)
            2 -> navController.navigate(R.id.songFragment)
            3 -> navController.navigate(R.id.genesFragment)
        }
    }

    private fun initFragment(view: View) {
        rcv = view.findViewById(R.id.rcvTabLibrary) as RecyclerView
        list = ArrayList()
        libraryViewModel = ViewModelProviders.of(this).get(LibraryViewModel::class.java)
    }

    private fun handleViewModel() {
        libraryViewModel.getListTab().observe(this, Observer<ArrayList<TabLibraryClass>> {
            list = it
            rcv.adapter!!.notifyDataSetChanged()
        })
    }

    override fun addEvent(view: View) {
        navController= mActivity.findNavController(R.id.navTabLibrary)
        mActivity.showToastLong("${navController.currentDestination!!.label}")
        /*Tab default*/
        chooseTab(0)
        list.setItem(mActivity, list)
        libraryViewModel.addListTab(list)
    }

    override fun onBackFragment() {
        super.onBackFragment()
        mActivity.showToastShort("0")
    }
}