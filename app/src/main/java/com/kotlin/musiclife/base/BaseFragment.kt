package com.kotlin.musiclife.base

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

public abstract class BaseFragment : Fragment() {

    private var activity: BaseActivity? = null
    protected abstract fun getLayoutID(): Int
    protected abstract fun addControl()
    protected abstract fun addEvent()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        lateinit var view:View
        activity = getActivity() as BaseActivity?
        if (getLayoutID() > 0) {
            view = inflater.inflate(getLayoutID(), container, false)
            handleBackDevice(view)
            addControl()
        } else {
            Toast.makeText(activity,"Layout error", Toast.LENGTH_SHORT).show()
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
        view.setOnKeyListener { v: View?, keyCode: Int, event: KeyEvent ->
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
        activity!!.onBackPressed()
    }

}