package com.aixue.framework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by haha on 2019/11/21.
 * 基类
 * 为什么不用RxFragment，原因RxFragment继承的Fragment，不是androidX包下的，
 * 而androidx是未来的趋势。
 * 另外FragmentAdapter用的androidx,而androidx是未来的趋势
 *
 */
open class BaseFragment : Fragment() {

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

    open fun toast(msg:String){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

}