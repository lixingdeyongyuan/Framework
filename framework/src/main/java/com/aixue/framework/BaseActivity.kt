package com.aixue.framework

import android.os.Bundle
import com.aixue.framework.log.LogProxy
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity

/**
 * Created by haha on 2019/11/21.
 * 主要用来实现公用逻辑
 * 比如toast,后台service的连接
 * 继承自RxAppCompatActivity原因，是实现请求数据
 */
open class BaseActivity : RxAppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogProxy.getInstance().debug(null, "${this.javaClass.name}.onCreate")
    }

    public override fun onStart() {
        super.onStart()
        LogProxy.getInstance().debug(null, "${this.javaClass.name}.onStart")
    }

    public override fun onResume() {
        super.onResume()
        LogProxy.getInstance().debug(null, "${this.javaClass.name}.onResume")
    }

    public override fun onPause() {
        super.onPause()
        LogProxy.getInstance().debug(null, "${this.javaClass.name}.onPause")
    }

    public override fun onStop() {
        super.onStop()
        LogProxy.getInstance().debug(null, "${this.javaClass.name}.onStop")
    }

    public override fun onDestroy() {
        super.onDestroy()
        LogProxy.getInstance().debug(null, "${this.javaClass.name}.onDestroy")
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right)
    }
}