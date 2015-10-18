package com.event.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import de.greenrobot.event.EventBus;

/**
 * Created by zhanglin on 15/10/17.
 */
public class BaseActivity extends Activity {
    OnActivityEventBus onActivityEventBus;
    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onActivityEventBus = new OnActivityEventBus();
        EventBus.getDefault().register(onActivityEventBus);
        activity = this;
    }


    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(onActivityEventBus);
        super.onDestroy();

    }

    public class OnActivityEventBus{

        public void onEvent(BaseActivityEvent baseActivityEvent){
            if(BaseActivityEvent.exitApp == baseActivityEvent.event){
                finish();
                Log.i("shuai","activity "+activity.getClass().getName());
            }
        }
    }
}
