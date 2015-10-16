package com.qq315301615.android_study.sqlite.event_bus;

import com.squareup.otto.Bus;

/**
 * event bus provider
 * Created by zhanglin on 15/10/15.
 */
public class OttoEventBusProvider {
    private static final Bus bus = new Bus();
    public Bus getInstance(){
        return bus;
    }
}
