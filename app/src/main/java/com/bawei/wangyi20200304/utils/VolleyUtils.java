package com.bawei.wangyi20200304.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.wangyi20200304.base.App;

import java.util.Map;

/**
 * 网络工具类
 */
public class VolleyUtils {
    //请求队列
    RequestQueue mQueue;

    private VolleyUtils() {
        mQueue = Volley.newRequestQueue(App.getAppContext());
    }
    //静态内部类
    private static class SingleIntance{
        private static VolleyUtils INSTANCE= new VolleyUtils();
    }
      public  static  VolleyUtils getInstance() {
        return  SingleIntance.INSTANCE;
    }
    //接口回调
    public interface CallBack{
     void Success(String json);
     void Error(String msg);
    }
    //get请求
    public void doGet(String url, final CallBack callBack){
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.Success(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.Error(error.getMessage());

            }
        });
        mQueue.add(request);
    }
    //post请求
    public void doPost(String url, Map<String,String> map, final CallBack callBack){
        new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.Success(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.Error(error.getMessage());

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
    }
}
