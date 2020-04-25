package com.aixue.sodu.main

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity

/**
 * Created by haha on 2019/11/21.
 * 主要用来实现公用逻辑
 * 比如toast,后台service的连接
 * 继承自RxAppCompatActivity原因，是实现请求数据
 */
open class BaseActivity : RxAppCompatActivity() {
}