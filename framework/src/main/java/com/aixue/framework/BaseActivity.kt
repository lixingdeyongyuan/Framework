package com.aixue.sodu.main

import com.aixue.framework.R
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity

/**
 * Created by haha on 2019/11/21.
 * 主要用来实现公用逻辑
 * 比如toast,后台service的连接
 * 继承自RxAppCompatActivity原因，是实现请求数据
 */
open class BaseActivity : RxAppCompatActivity() {

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right)
    }
}