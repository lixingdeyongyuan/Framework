package com.aixue.framework;

import android.os.Bundle;

import com.aixue.framework.swipeback.BaseSwipeBackActivity;

import org.jetbrains.annotations.Nullable;


public class Haha extends BaseSwipeBackActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haha);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.flhaha,new Test()).commitAllowingStateLoss();
        }

    }
}
