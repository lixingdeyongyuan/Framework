package com.aixue.framework

import android.os.Bundle
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
}