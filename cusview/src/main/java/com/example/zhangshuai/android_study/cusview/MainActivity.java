package com.example.zhangshuai.android_study.cusview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zhangshuai.android_study.cusview.bt_0.BT0Activity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    OnViewClickListener onViewClickListener = new OnViewClickListener();
    @Bind(R.id.bt_0)
    Button bt_0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bt_0.setOnClickListener(onViewClickListener);

    }
    private class OnViewClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.bt_0:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, BT0Activity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
