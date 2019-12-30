package com.bawei.xm1130week01lx;

import android.app.Application;

/**
 * author: 斛万珺
 * data: 2019/12/30 13:13:33
 * function:
 */
public class App extends Application {

    public static  App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
}
