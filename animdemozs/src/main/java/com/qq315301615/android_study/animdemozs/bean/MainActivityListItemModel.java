package com.qq315301615.android_study.animdemozs.bean;

import android.app.Activity;

/**
 * Created by 123 on 2015/10/26.
 */
public class MainActivityListItemModel {
    String strgTitle;
    Class<Activity> clasActivity;

    public MainActivityListItemModel() {
    }

    public MainActivityListItemModel(Class<Activity> clsActivity, String stgTitle) {
        this.clasActivity = clsActivity;
        this.strgTitle = stgTitle;
    }

    @Override
    public String toString() {
        return strgTitle;
    }
}
