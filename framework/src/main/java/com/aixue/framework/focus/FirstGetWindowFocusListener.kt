package com.aixue.framework.focus

import android.os.Bundle
import com.aixue.framework.BaseActivity

/**
 * 检查第一次获取焦点后的回调
 * 主要目的：
 * 1.当获取焦点后，才能弹出键盘来
 */
class FirstGetWindowFocusListener(var mBaseActivity: BaseActivity) {

    companion object {
        const val KEY_IS_EVER_HAD_FOCUS = "key_is_ever_had_focus"
    }

    /**
     *  是否有过焦点；当界面会销毁后会记录状态
     */
    private var mIsEverHadFocus = false
    private var mOnFirstGetWindowFocusListeners: ArrayList<OnFirstGetWindowFocusListener>? = null

    fun onViewCreated(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            if (it.containsKey(KEY_IS_EVER_HAD_FOCUS)) {
                mIsEverHadFocus = it.getBoolean(KEY_IS_EVER_HAD_FOCUS)
            }
        }
        mBaseActivity.addOnWindowFocusChangeListener(object :
            OnWindowFocusChangeListener {
            override fun onWindowFocusChanged(hasFocus: Boolean) {
                if (mIsEverHadFocus) {
                    return
                }
                if (!hasFocus) {
                    return
                }
                mIsEverHadFocus = true
                mOnFirstGetWindowFocusListeners?.forEach {
                    it.onFirstGetWindowFocus()
                }
            }
        })
    }

    fun onViewStateRestored(savedInstanceState: Bundle?) {
        savedInstanceState?.putBoolean(KEY_IS_EVER_HAD_FOCUS, mIsEverHadFocus)
    }

    fun addOnFirstGetWindowFocusListener(onFirstGetWindowFocusListener: OnFirstGetWindowFocusListener) {
        if (mOnFirstGetWindowFocusListeners == null) {
            mOnFirstGetWindowFocusListeners = ArrayList<OnFirstGetWindowFocusListener>()
        }
        mOnFirstGetWindowFocusListeners?.add(onFirstGetWindowFocusListener)
    }

    fun removeOnFirstGetWindowFocusListener(onFirstGetWindowFocusListener: OnFirstGetWindowFocusListener) {
        mOnFirstGetWindowFocusListeners?.remove(onFirstGetWindowFocusListener)
    }

    fun clearOnFirstGetWindowFocusListener() {
        mOnFirstGetWindowFocusListeners?.clear()
    }

}