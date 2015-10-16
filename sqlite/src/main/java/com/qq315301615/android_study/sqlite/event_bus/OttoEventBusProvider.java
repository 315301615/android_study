package com.qq315301615.android_study.sqlite.event_bus;


import com.google.common.eventbus.EventBus;

/**
 * event bus provider
 * Created by zhanglin on 15/10/15.
 */
public class OttoEventBusProvider {
    static final EventBus eventBus = new EventBus();
    public static EventBus getInstance(){
        return eventBus;
    }

}
