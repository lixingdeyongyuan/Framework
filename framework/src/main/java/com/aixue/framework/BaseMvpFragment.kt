package com.aixue.sodu.main

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.aixue.framework.RxLifecycleUtils
import com.uber.autodispose.AutoDisposeConverter

open abstract class BaseMvpFragment<P : BasePresenter<V>, V : BaseView> : BaseFragment(), BaseView {

    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 这里初始化Presenter,同时把Presenter的view初始化是很合理的
        mPresenter = createPresenter()
        mPresenter.onViewAttached(this)
        lifecycle.addObserver(mPresenter)
    }


    abstract fun createPresenter(): P

    override fun <T> bindToLifecycle(): AutoDisposeConverter<T> {
        return RxLifecycleUtils.bindToLifecycle(this, null)
    }

    override fun <T> bindToLifecycle(event: Lifecycle.Event): AutoDisposeConverter<T> {
        return RxLifecycleUtils.bindToLifecycle(this, event)
    }

    override fun getLifecycleOwner(): LifecycleOwner {
        return this
    }
}