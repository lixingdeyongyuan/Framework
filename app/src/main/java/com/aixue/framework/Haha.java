package com.aixue.framework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aixue.framework.swipeback.BaseSwipeBackActivity;

import org.jetbrains.annotations.Nullable;


public class Haha extends BaseSwipeBackActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haha);

        TextView textView = findViewById(R.id.haha);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Haha.this, TestActivitu.class);
                startActivity(intent);
            }
        });
    }
}
