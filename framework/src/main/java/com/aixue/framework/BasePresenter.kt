package com.aixue.framework

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.aixue.framework.log.LogProxy
import com.uber.autodispose.AutoDisposeConverter

open class BasePresenter<V : BaseView> : LifecycleEventObserver, FullLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        LogProxy.getInstance().debug(null, "${this.javaClass.name}.onCreate ")
    }

    override fun onStart(owner: LifecycleOwner) {
        LogProxy.getInstance().debug(null,"${this.javaClass.name}.onStart ")
    }

    override fun onResume(owner: LifecycleOwner) {
        LogProxy.getInstance().debug(null,"${this.javaClass.name}.onResume ")
    }

    override fun onPause(owner: LifecycleOwner) {
        LogProxy.getInstance().debug(null,"${this.javaClass.name}.onPause ")
    }

    override fun onStop(owner: LifecycleOwner) {
        LogProxy.getInstance().debug(null,"${this.javaClass.name}.onStop ")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        LogProxy.getInstance().debug(null,"${this.javaClass.name}.onDestroy ")
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        LogProxy.getInstance().debug(null,"BasePresenter.onStateChanged ${this.javaClass.name} ${event}")
        when (event) {
            Lifecycle.Event.ON_CREATE -> onCreate(source)
            Lifecycle.Event.ON_START -> onStart(source)
            Lifecycle.Event.ON_RESUME -> onResume(source)
            Lifecycle.Event.ON_PAUSE -> onPause(source)
            Lifecycle.Event.ON_STOP -> onStop(source)
            Lifecycle.Event.ON_DESTROY -> onDestroy(source)
            Lifecycle.Event.ON_ANY -> throw IllegalArgumentException("ON_ANY must not been send by anybody")
        }
    }


    private lateinit var mBaseView: V


    open fun onViewAttached(view: BaseView) {
        LogProxy.getInstance().debug(null,"${this.javaClass.name}.onViewAttached ")
        mBaseView = view as V
    }

    open fun onViewDetached() {

    }

    open fun getView(): V {
        return mBaseView
    }

    /**
     * 返回 BaseView 的 AutoDisposeConverter
     */
    fun <T> bindToLifecycle(): AutoDisposeConverter<T> {
        return mBaseView.bindToLifecycle()
    }

    fun <T> bindToLifecycle(event: Lifecycle.Event): AutoDisposeConverter<T> {
        return mBaseView.bindToLifecycle(event)
    }
}