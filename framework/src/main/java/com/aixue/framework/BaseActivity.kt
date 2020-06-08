package com.aixue.framework

import android.os.Bundle
import com.aixue.dialogmgr.DialogMgr
import com.aixue.framework.focus.OnWindowFocusChangeListener
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity

/**
 * Created by haha on 2019/11/21.
 * 主要用来实现公用逻辑
 * 比如toast,后台service的连接
 * 继承自RxAppCompatActivity原因，是实现请求数据
 */
open class BaseActivity : RxAppCompatActivity() {

    private var mOnWindowFocusChangeListeners: ArrayList<OnWindowFocusChangeListener>? = null

    private var mDialogMgr: DialogMgr? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    public override fun onStart() {
        super.onStart()
    }

    public override fun onResume() {
        super.onResume()
    }

    public override fun onPause() {
        super.onPause()
    }

    public override fun onStop() {
        super.onStop()
    }

    public override fun onDestroy() {
        super.onDestroy()
    }

    public fun getDialogMgr(): DialogMgr {
        if (mDialogMgr == null) {
            mDialogMgr = DialogMgr(supportFragmentManager)
        }
        return mDialogMgr!!
    }


    fun addOnWindowFocusChangeListener(onWindowFocusChangeListener: OnWindowFocusChangeListener) {
        if (mOnWindowFocusChangeListeners == null) {
            mOnWindowFocusChangeListeners = ArrayList<OnWindowFocusChangeListener>()
        }
        mOnWindowFocusChangeListeners?.add(onWindowFocusChangeListener)
    }

    fun removeOnWindowFocusChangeListener(onWindowFocusChangeListener: OnWindowFocusChangeListener) {
        mOnWindowFocusChangeListeners?.remove(onWindowFocusChangeListener)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        mOnWindowFocusChangeListeners?.forEach {
            it.onWindowFocusChanged(hasFocus)
        }
    }

}