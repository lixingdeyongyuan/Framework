package com.aixue.framework

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.aixue.framework.focus.FirstGetWindowFocusListener
import com.aixue.framework.focus.OnFirstGetWindowFocusListener
import com.aixue.dialogmgr.DialogMgr
import com.gyf.immersionbar.components.ImmersionOwner
import com.gyf.immersionbar.components.ImmersionProxy

/**
 * Created by haha on 2019/11/21.
 * 基类
 * 为什么不用RxFragment，原因RxFragment继承的Fragment，不是androidX包下的，
 * 而androidx是未来的趋势。
 * 另外FragmentAdapter用的androidx,而androidx是未来的趋势
 *
 */
open class BaseFragment : Fragment(), ImmersionOwner {

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

    private var mImmersionProxy: ImmersionProxy? = null
    private var mDialogMgr: DialogMgr? = null

    init {
        if (isImmersion()) {
            mImmersionProxy = ImmersionProxy(this)
        }
    }

    open fun isImmersion(): Boolean {
        return true
    }

    override fun onLazyAfterView() {

    }

    override fun onInvisible() {
    }

    override fun onLazyBeforeView() {
    }

    override fun immersionBarEnabled(): Boolean {
        return isImmersion()
    }

    override fun onVisible() {
    }

    override fun initImmersionBar() {
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        mImmersionProxy?.isUserVisibleHint = isVisibleToUser
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mImmersionProxy?.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mImmersionProxy?.onActivityCreated(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        mImmersionProxy?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mImmersionProxy?.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mImmersionProxy?.onDestroy()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        mImmersionProxy?.onHiddenChanged(hidden)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mImmersionProxy?.onConfigurationChanged(newConfig)
    }

    open fun toast(msg: CharSequence) {
        Toast.makeText(this.context, msg, Toast.LENGTH_LONG).show()
    }

    public fun getDialogMgr(): DialogMgr {
        if (mDialogMgr == null) {
            mDialogMgr = DialogMgr(childFragmentManager)
        }
        return mDialogMgr!!
    }
}