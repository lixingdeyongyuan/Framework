package com.aixue.framework

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.aixue.dialogmgr.DialogMgr
import com.uber.autodispose.AutoDisposeConverter

interface BaseView {
    abstract fun getLifecycleOwner(): LifecycleOwner

    /**
     * 获取 AutoDisposeConverter
     */
    abstract fun <T> bindToLifecycle(): AutoDisposeConverter<T>

    abstract fun <T> bindToLifecycle(event: Lifecycle.Event): AutoDisposeConverter<T>

    fun getDialogMgr(): DialogMgr
}