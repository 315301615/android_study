package com.qq315301615.android_study.fragmentstudy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private FrameLayout main_activity_fragment_container;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private OneFragment fragmentOne;
    private TwoFragment fragmentTwo;
    @Bind(R.id.activity_main_bt_change_fragment)
    Button activity_main_bt_change_fragment;
    /**
     * fragment tow 中，通知text内容进行了改变
     */
    RemaindFragmentTwoChange remaindFragmentTwoChange;
    /**
     * fragent one 中，监听text变化
     */
    OnFragmentOneEditTextChangeListener onFragmentOneEditTextChangeListener = new OnFragmentOneEditTextChangeListener();

    /**
     * 点击事件监听器
     */
    private OnViewClickListener onViewClickListener = new OnViewClickListener();
    /**
     * fragment 使用标志位
     */
    private int fragmentFlag = 0;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
        setEvent();
        initRunSomeThing();
    }

    private void initRunSomeThing() {

    }

    private void setEvent() {
        //activity_main_bt_change_fragment.setOnClickListener(onViewClickListener);
    }

    private void initData() {
        fragmentFlag = 1;
        fragmentOne = new OneFragment();
        fragmentOne.setEditTextListener(onFragmentOneEditTextChangeListener);
        fragmentTwo = new TwoFragment();
        remaindFragmentTwoChange = fragmentTwo.getOnFragmentOneChange();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_activity_fragment_container_0, fragmentOne).commit();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_activity_fragment_container_1, fragmentTwo).commit();

    }

    private void initView() {

    }

    @OnClick(R.id.activity_main_bt_change_fragment)
    public void butClick() {
        Toast.makeText(this, "dianji", Toast.LENGTH_SHORT).show();
    }

    /**
     * 更具非让梦标志位，改变fragment
     */
    private void changeFragment() {
        Fragment tempFragment = null;
        if (fragmentFlag == 1) {
            fragmentFlag = 2;
            tempFragment = fragmentTwo;
        } else {
            fragmentFlag = 1;
            tempFragment = fragmentOne;
        }
    }

    private class OnViewClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.activity_main_bt_change_fragment:
                    changeFragment();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 用于检测one fragment中文字的改变
     */
    class OnFragmentOneEditTextChangeListener implements OneFragment.EditTextListener {

        @Override
        public void onTextChange(String strMsg) {
            //将改变的值传递给，twofragment
            remaindFragmentTwoChange.onTextChange(strMsg);
        }
    }

    /**
     * 用于通知 two fragment中的文字改变
     */
    public interface RemaindFragmentTwoChange {
        public void onTextChange(String strMsg);
    }
}
