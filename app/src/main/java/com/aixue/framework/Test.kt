package com.aixue.framework

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aixue.framework.focus.OnFirstGetWindowFocusListener

class Test : BaseFragment(), OnFirstGetWindowFocusListener {
    override fun onFirstGetWindowFocus() {
        Log.d("rlog", "Test.onFirstGetWindowFocus ")
    }

    override fun isListenFirstGetWindowFocus(): Boolean {
        return true
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.haha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addOnFirstGetWindowFocusListener(this)
    }

}