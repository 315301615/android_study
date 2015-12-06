package com.example.zhangshuai.android_study.listheaderfooter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.lv_test)
    ListView lv_test;
    View header;
    View footer;
    Activity mActivity;
    LayoutInflater mLayoutInflater;
    LVAdatper lvAdatper = new LVAdatper();
    boolean hasHeader = false;
    int lvItemSize = 0;
    Handler mhandler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        ButterKnife.bind(mActivity);
        mhandler = new Handler() {
            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {

            }
        };
        mLayoutInflater = LayoutInflater.from(mActivity);
        initView();
        reShowLV();
    }

    private void reShowLV() {
        if(hasHeader){
            lv_test.addHeaderView(header);
        }
        if(lvItemSize > 0){

        }
    }

    private void initView() {
        header = mLayoutInflater.inflate(R.layout.header, null);
        footer = mLayoutInflater.inflate(R.layout.footer, null);
        lv_test.addHeaderView(header);
        lv_test.addFooterView(footer);
        lv_test.setAdapter(lvAdatper);
    }


    private class LVAdatper extends BaseAdapter {
        @Override
        public int getCount() {
            return lvItemSize;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = mLayoutInflater.inflate(R.layout.item, null);
            }
            return convertView;
        }
    }

}
