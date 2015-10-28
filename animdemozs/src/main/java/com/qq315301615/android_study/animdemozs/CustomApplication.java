package com.qq315301615.android_study.animdemozs;

import android.app.Application;

/**
 * Created by 123 on 2015/10/26.
 */
public class CustomApplication extends Application{
    private static CustomApplication instance ;

    public CustomApplication() {
        instance = this;
    }

    public static CustomApplication getInstance(){
        return instance;
    }
}
