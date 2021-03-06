package com.aixue.framework

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

interface FullLifecycleObserver : LifecycleObserver {

    fun onCreate(owner: LifecycleOwner)

    fun onStart(owner: LifecycleOwner)

    fun onResume(owner: LifecycleOwner)

    fun onPause(owner: LifecycleOwner)

    fun onStop(owner: LifecycleOwner)

    fun onDestroy(owner: LifecycleOwner)

}