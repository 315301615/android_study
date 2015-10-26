package com.qq315301615.android_study.animdemozs.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.qq315301615.android_study.animdemozs.ClickListener.MainActivityListOnItemClickListener;
import com.qq315301615.android_study.animdemozs.R;
import com.qq315301615.android_study.animdemozs.adapter.MainActivityListAdapter;
import com.qq315301615.android_study.animdemozs.bean.MainActivityListItemModel;

public class MainActivity extends AppCompatActivity {
    ListView activity_main_list_activity;
    MainActivityListItemModel[] arryMainActivityListItemModel;
    MainActivityListAdapter mainActivityListAdapter = new MainActivityListAdapter();
    MainActivityListOnItemClickListener mainActivityListOnItemClickListener = new MainActivityListOnItemClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arryMainActivityListItemModel = new MainActivityListItemModel[]{


        };
        mainActivityListOnItemClickListener.mainActivityListAdapter = mainActivityListAdapter;
        mainActivityListAdapter.arryMainActivityListItemModel = arryMainActivityListItemModel;
        activity_main_list_activity = (ListView) findViewById(R.id.activity_main_list_activity);
        activity_main_list_activity.setAdapter(mainActivityListAdapter);
        activity_main_list_activity.setOnItemClickListener(mainActivityListOnItemClickListener);
    }

}
