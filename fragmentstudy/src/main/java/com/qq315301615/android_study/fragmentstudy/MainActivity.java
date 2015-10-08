package com.qq315301615.android_study.fragmentstudy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private FrameLayout main_activity_fragment_container;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private OneFragment fragmentOne;
    private TwoFragment fragmentTwo;

    private Button activity_main_bt_change_fragment;

    /**
     * 点击事件监听器
     */
    private OnViewClickListener onViewClickListener = new OnViewClickListener();
    /**
     * fragment 使用标志位
     */
    private int fragmentFlag = 0;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        setEvent();
    }

    private void setEvent() {
        activity_main_bt_change_fragment.setOnClickListener(onViewClickListener);
    }

    private void initData() {
        fragmentFlag = 1;
        fragmentOne = new OneFragment();
        fragmentTwo = new TwoFragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_activity_fragment_container, fragmentOne).commit();
    }

    private void initView() {
        main_activity_fragment_container = (FrameLayout) findViewById(R.id.main_activity_fragment_container);
        activity_main_bt_change_fragment = (Button) findViewById(R.id.activity_main_bt_change_fragment);
    }

    /**
     * 更具非让梦标志位，改变fragment
     */
    private void changeFragment(){
        Fragment tempFragment = null;
        if(fragmentFlag==1){
            fragmentFlag = 2;
            tempFragment = fragmentTwo;
        }else{
            fragmentFlag=1;
            tempFragment = fragmentOne;
        }
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_fragment_container, tempFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private class OnViewClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.activity_main_bt_change_fragment:
                    changeFragment();
                    break;
                default:
                    break;
            }
        }
    }
}
