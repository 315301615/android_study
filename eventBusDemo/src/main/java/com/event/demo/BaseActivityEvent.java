package com.event.demo;

/**
 * Created by zhanglin on 15/10/17.
 */
public class BaseActivityEvent {
    public int event;
    public static final int exitApp = 1;

    public BaseActivityEvent(int event) {
        this.event = event;
    }
}
