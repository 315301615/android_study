package com.event.demo;

import android.os.Bundle;
import android.view.View;

import de.greenrobot.event.EventBus;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }
    public void closeApplication(View view){
        EventBus.getDefault().post(new BaseActivityEvent(BaseActivityEvent.exitApp));
    }
}
