package com.qq315301615.android_study.animdemozs.bean;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by 123 on 2015/10/26.
 */
public class MainActivityListItemModel {
    public String strgTitle;
    public Class<? extends AppCompatActivity> clasActivity;

    public MainActivityListItemModel() {
    }

    public MainActivityListItemModel(Class<? extends AppCompatActivity> clsActivity, String stgTitle) {
        this.clasActivity = clsActivity;
        this.strgTitle = stgTitle;
    }

    @Override
    public String toString() {
        return strgTitle;
    }
}
