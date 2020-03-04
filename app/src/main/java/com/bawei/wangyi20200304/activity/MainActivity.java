package com.bawei.wangyi20200304.activity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.wangyi20200304.R;
import com.bawei.wangyi20200304.base.BaseActivity;
import com.bawei.wangyi20200304.bean.ShoppingInfo;
import com.bawei.wangyi20200304.utils.VolleyUtils;
import com.google.gson.Gson;

public class MainActivity extends BaseActivity {


    private GridView gv;
    private EditText et;
    private ImageView iv;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //找控件
        gv = findViewById(R.id.gv);
        et = findViewById(R.id.et);
        iv = findViewById(R.id.iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = et.getText().toString();
                Toast.makeText(MainActivity.this, ""+string, Toast.LENGTH_SHORT).show();
                Log.i("xxx",string);
            }
        });
    }

    @Override
    protected void initData() {
        VolleyUtils.getInstance().doGet("", new VolleyUtils.CallBack() {
            @Override
            public void Success(String json) {
                Log.i("xxx",json);
                Gson gson = new Gson();
                ShoppingInfo shoppingInfo = gson.fromJson(json, ShoppingInfo.class);

            }

            @Override
            public void Error(String msg) {
                Log.i("xxx",msg);

            }
        });

    }
}
