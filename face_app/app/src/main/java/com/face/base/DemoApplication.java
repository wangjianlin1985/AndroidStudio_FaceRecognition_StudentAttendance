package com.face.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;


public class DemoApplication extends MultiDexApplication {
    private static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;


    }

    public static Context getAppContext() {
        return instance;
    }
}