package com.bawei.wangyi20200304.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bawei.wangyi20200304.R;

public  abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
    }
    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initData();
}
