package com.kotlin.musiclife.base

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.musiclife.R
import com.kotlin.musiclife.utils.extensions.*

abstract class BaseFragment : Fragment() {
    protected lateinit var mActivity: BaseActivity
    protected abstract fun getLayoutID(): Int
    protected abstract fun addControl(view: View)
    protected abstract fun addEvent()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var view: View
        mActivity = activity as BaseActivity
        if (getLayoutID() > 0) {
            view = inflater.inflate(getLayoutID(), container, false)
            handleBackDevice(view)
            addControl(view)
        } else {
            mActivity.showToastLong(getString(R.string.not_found_fragment))
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (getLayoutID() > 0) {
            addEvent()
        }
    }

    private fun handleBackDevice(view: View) {
        view.isFocusableInTouchMode = true
        view.requestFocus()
        view.setOnKeyListener { _: View?, keyCode: Int, event: KeyEvent ->
            if (event.action == KeyEvent.ACTION_UP) {
                if (keyCode == KeyEvent.KEYCODE_BACK) { //On back event Fragment
                    onBackFragment()
                    return@setOnKeyListener true
                }
            }
            false
        }
    }

    open fun onBackFragment() {
        mActivity.onBackPressed()
    }

}