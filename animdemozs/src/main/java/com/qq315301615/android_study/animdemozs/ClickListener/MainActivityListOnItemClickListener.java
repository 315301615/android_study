package com.qq315301615.android_study.animdemozs.ClickListener;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qq315301615.android_study.animdemozs.CustomApplication;
import com.qq315301615.android_study.animdemozs.adapter.MainActivityListAdapter;
import com.qq315301615.android_study.animdemozs.bean.MainActivityListItemModel;

/**
 * Created by 123 on 2015/10/26.
 */
public class MainActivityListOnItemClickListener implements ListView.OnItemClickListener{
    public MainActivityListAdapter mainActivityListAdapter;
    MainActivityListItemModel mainActivityListItemModel;
    Intent intent;
    Context context;

    public MainActivityListOnItemClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mainActivityListItemModel = (MainActivityListItemModel) mainActivityListAdapter.getItem(position);
        intent = new Intent();
        intent.setClass(context, mainActivityListItemModel.getClass());
        CustomApplication.getInstance().startActivity(intent);
    }
}
