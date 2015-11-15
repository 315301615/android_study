package com.example.zhangshuai.android_study.viewpagerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.vp_test)
    ViewPager vp_test;
    @Bind(R.id.lv_test)
    ListView lv_test;
    VPFragmentAdapter vpFragmentAdapter;
    Context context;
    LVTestAdapter lvTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        vpFragmentAdapter = new VPFragmentAdapter(getSupportFragmentManager());
        vp_test.setAdapter(vpFragmentAdapter);
        lvTestAdapter = new LVTestAdapter();
        vp_test.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, 100));
        lv_test.addHeaderView(vp_test);
        lv_test.setAdapter(lvTestAdapter);
    }
    private class VPFragmentAdapter extends FragmentPagerAdapter{
        Fragment vpFragment;
        Bundle bundle;

        public VPFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            vpFragment = new VPFragment();
            bundle = new Bundle();
            bundle.putString(VPFragment.TEXT_KEY,position+"");
            vpFragment.setArguments(bundle);
            return vpFragment;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return position+"";
        }
    }
    class LVTestAdapter extends BaseAdapter{
        Holder holder;
        @Override
        public int getCount() {
            return 50;
        }

        @Override
        public Object getItem(int position) {
            return position+"";
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView = View.inflate(context,R.layout.item_listview,null);
                holder = new Holder(convertView);
                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }
            holder.tv.setText((String)getItem(position));
            return convertView;
        }
        public class Holder{
            @Bind(R.id.tv_listview)
            TextView tv;

            public Holder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
