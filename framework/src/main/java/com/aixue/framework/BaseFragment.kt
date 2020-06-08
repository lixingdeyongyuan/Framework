package com.aixue.framework

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.aixue.framework.focus.FirstGetWindowFocusListener
import com.aixue.framework.focus.OnFirstGetWindowFocusListener

/**
 * Created by haha on 2019/11/21.
 * 基类
 * 为什么不用RxFragment，原因RxFragment继承的Fragment，不是androidX包下的，
 * 而androidx是未来的趋势。
 * 另外FragmentAdapter用的androidx,而androidx是未来的趋势
 *
 */
open class BaseFragment : Fragment() {

    open fun isListenFirstGetWindowFocus(): Boolean {
        return false
    }

    private var mFirstFocus: FirstGetWindowFocusListener? = null

    fun getFirstGetWindowFocusListener(): FirstGetWindowFocusListener? {
        if (!isListenFirstGetWindowFocus()) {
            return null
        }
        if (!(activity is BaseActivity)) {
            return null
        }
        if (mFirstFocus != null) {
            return mFirstFocus
        }
        mFirstFocus = FirstGetWindowFocusListener(activity as BaseActivity)
        return mFirstFocus
    }

    open fun addOnFirstGetWindowFocusListener(onFirstGetWindowFocusListener: OnFirstGetWindowFocusListener) {
        getFirstGetWindowFocusListener()?.addOnFirstGetWindowFocusListener(
            onFirstGetWindowFocusListener
        )
    }

    open fun removeOnFirstGetWindowFocusListener(onFirstGetWindowFocusListener: OnFirstGetWindowFocusListener) {
        getFirstGetWindowFocusListener()?.removeOnFirstGetWindowFocusListener(
            onFirstGetWindowFocusListener
        )
    }

    fun clearOnFirstGetWindowFocusListener() {
        getFirstGetWindowFocusListener()?.clearOnFirstGetWindowFocusListener()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFirstGetWindowFocusListener()?.onViewCreated(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        getFirstGetWindowFocusListener()?.onViewStateRestored(outState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    open fun toast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

}