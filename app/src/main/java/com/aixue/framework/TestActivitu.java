package com.aixue.framework;

import android.os.Bundle;

import org.jetbrains.annotations.Nullable;

public class TestActivitu extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haha);

        getSupportFragmentManager().beginTransaction().add(R.id.test,new Test()).commitAllowingStateLoss();
    }
}
