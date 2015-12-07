package com.razeor.wigi.tvdog.testsrl_listview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static int LV_STATE_FLAG = -1;
    //默认状态初始状态
    private static final int LV_STATE_NORMAL = 0;
    //刷新中
    private static final int LV_STATE_REFRESH_ING = 1;
    //刷新失败
    private static final int LV_STATE_REFRESH_ERROR = 2;
    //加载中
    private static final int LV_STATE_LOAD_ING = 3;
    //加载失败
    private static final int LV_STATE_LOAD_ERROR = 4;
    @Bind(R.id.srl_test)
    SwipeRefreshLayout srl_test;
    @Bind(R.id.lv_test)
    ListView lv_test;
    TextView tv_lv_footer;
    View header;
    View footer;
    Activity mActivity;
    LayoutInflater mLayoutInflater;
    LVAdatper lvAdatper = new LVAdatper();
    int lvItemSize = 0;
    Handler mhandler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        ButterKnife.bind(mActivity);
        mhandler = new Handler();
        mLayoutInflater = LayoutInflater.from(mActivity);
        srl_test.setOnRefreshListener(new MSRLOnRefreshListener());
        LV_STATE_FLAG = LV_STATE_REFRESH_ING;
        srl_test.setRefreshing(true);

/*        initView();
        reShowLV();*/
    }


    private void reShowLV() {
        lv_test.setAdapter(null);
        Runnable runnable = null;
        switch (LV_STATE_FLAG){
            case LV_STATE_NORMAL:
                //展示header
                if(lvItemSize<1){
                    lv_test.removeHeaderView(header);
                }else if(lv_test.getHeaderViewsCount()<1){
                    lv_test.addHeaderView(header);
                }
                //展示列表内容
                lvAdatper.notifyDataSetChanged();
                //隐藏footer
                if(lv_test.getFooterViewsCount()>0){
                    tv_lv_footer.setText("");
                    lv_test.removeFooterView(footer);
                }
                break;
            case LV_STATE_REFRESH_ING:
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        srl_test.setRefreshing(false);
                        LV_STATE_FLAG = LV_STATE_NORMAL;
                        lvItemSize = 20;
                        reShowLV();
                    }
                };
                break;
            case LV_STATE_REFRESH_ERROR:
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        srl_test.setRefreshing(false);
                        LV_STATE_FLAG = LV_STATE_NORMAL;
                        showToast("刷新失败，请重试");
                    }
                };
                break;
            case LV_STATE_LOAD_ING:
                lv_test.addFooterView(footer);
                tv_lv_footer.setText("正在加载更多");
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        srl_test.setRefreshing(false);
                        LV_STATE_FLAG = LV_STATE_NORMAL;
                        lvItemSize += 20;
                        reShowLV();
                    }
                };
                break;
            case LV_STATE_LOAD_ERROR:
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        LV_STATE_FLAG = LV_STATE_NORMAL;
                        showToast("加载更多失败，请重试");
                    }
                };
                break;
            default:
                break;
        }
        if(runnable!=null){
            header.postDelayed(runnable, 2000);
        }
        lv_test.setAdapter(lvAdatper);
    }

    private void initView() {
        header = mLayoutInflater.inflate(R.layout.header, null);
        footer = mLayoutInflater.inflate(R.layout.footer, null);
        tv_lv_footer = (TextView) footer.findViewById(R.id.tv_lv_footer);
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
    private class MSRLOnRefreshListener implements SwipeRefreshLayout.OnRefreshListener{

        @Override
        public void onRefresh() {
            LV_STATE_FLAG = LV_STATE_REFRESH_ING;
            reShowLV();
        }
    }
    private void showToast(String msg){
        Toast.makeText(mActivity, msg, Toast.LENGTH_LONG).show();
    }
}
