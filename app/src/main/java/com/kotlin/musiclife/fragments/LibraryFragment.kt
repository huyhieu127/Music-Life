package com.kotlin.musiclife.fragments

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.musiclife.R
import com.kotlin.musiclife.adapters.TabLibraryAdapter
import com.kotlin.musiclife.adapters.TabLibraryAdapter.OnClickItemListener
import com.kotlin.musiclife.base.BaseFragment
import com.kotlin.musiclife.models.TabLibraryClass
import com.kotlin.musiclife.utils.commons.StartSnapHelper
import com.kotlin.musiclife.utils.extensions.showToastShort
import com.kotlin.musiclife.viewmodels.LibraryViewModel
import kotlinx.android.synthetic.main.fragment_library.*


class LibraryFragment : BaseFragment() {

    private lateinit var libraryViewModel: LibraryViewModel
    lateinit var list: ArrayList<TabLibraryClass>
    lateinit var rcv: RecyclerView

    override fun getLayoutID(): Int {
        return R.layout.fragment_library
    }

    override fun addControl(view: View) {
        initFragment(view)
        handleViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rcv.layoutManager =
            LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false)
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
            }
        })
        StartSnapHelper().attachToRecyclerView(rcv)

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
        });
        libraryViewModel.text.observe(this, Observer {
            text_home.text = it
        })
    }

    override fun addEvent() {
        list.add(TabLibraryClass("Discover", true))
        list.add(TabLibraryClass("Playlist", false))
        list.add(TabLibraryClass("Songs", false))
        list.add(TabLibraryClass("Genres", false))
        libraryViewModel.addListTab(list)
    }

    override fun onBackFragment() {
        mActivity.showToastShort(getString(R.string.text_exit_app))
    }
}