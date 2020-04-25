package com.aixue.framework;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public class RxLifecycleUtils {

    public static <T> AutoDisposeConverter<T> bindToLifecycle(LifecycleOwner lifecycleOwner) {
        return bindToLifecycle(lifecycleOwner, Lifecycle.Event.ON_DESTROY);
    }

    public static <T> AutoDisposeConverter<T> bindToLifecycle(LifecycleOwner lifecycleOwner,
                                                              Lifecycle.Event event) {
        if (event == null) {
            return AutoDispose.autoDisposable(
                    AndroidLifecycleScopeProvider.from(lifecycleOwner, Lifecycle.Event.ON_DESTROY)
            );
        } else {
            return AutoDispose.autoDisposable(
                    AndroidLifecycleScopeProvider.from(lifecycleOwner, event)
            );
        }
    }
}
