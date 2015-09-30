package com.example.zhangshuai.android_study.acticonbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context activityContext;
    private Button bt_main_activity_second;
    private OnViewClickListener onViewClickListener = new OnViewClickListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_main_activity_second = (Button) findViewById(R.id.bt_main_activity_second);
        bt_main_activity_second.setOnClickListener(onViewClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean booIsResolved = true;
        //处理选项按钮的点击事件
        switch (item.getItemId()){
            //搜索
            case R.id.action_search:
                Toast.makeText(activityContext,R.string.action_search,Toast.LENGTH_SHORT).show();
                break;
            //设置
            case R.id.action_settings:
                Toast.makeText(activityContext,R.string.action_setting,Toast.LENGTH_SHORT).show();
                break;
            //进入第二个页面
            case R.id.action_open_second_activity:
                gotoSecondActivity();
                break;
            default:
                booIsResolved = false;
                break;
        }
        //判断是否已经处理了点击事件
        if(booIsResolved){
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * 点击事件监听器
     */
    private class OnViewClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.bt_main_activity_second:
                    gotoSecondActivity();
                    break;
                default:
                    break;
            }
        }
    }
    private void gotoSecondActivity(){
        Intent intent = new Intent();
        intent.setClass(activityContext, ShowMessageActivity.class);
        startActivity(intent);
    }
}


