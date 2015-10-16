package com.qq315301615.android_study.sqlite.event_bus;

import com.qq315301615.android_study.sqlite.bean.model.DiaryDailyModel;

/**
 * Created by zhanglin on 15/10/15.
 */
public class DiaryListItemSelectEvent {
    DiaryDailyModel diaryDailyModel;

    public DiaryListItemSelectEvent(DiaryDailyModel diaryDailyModel) {
        this.diaryDailyModel = diaryDailyModel;
    }
}
