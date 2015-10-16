package com.qq315301615.android_study.sqlite.bean.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhanglin on 15/10/14.
 * diary each day`s name,such like time
 */
public class DiaryDailyModel implements Parcelable {
    /**
     * id
     */
    String id;
    /**
     * name
     */
    String stgName;
    /**
     * content
     */
    String Content;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.stgName);
        dest.writeString(this.Content);
    }

    public DiaryDailyModel() {
    }

    protected DiaryDailyModel(Parcel in) {
        this.id = in.readString();
        this.stgName = in.readString();
        this.Content = in.readString();
    }

    public static final Parcelable.Creator<DiaryDailyModel> CREATOR = new Parcelable.Creator<DiaryDailyModel>() {
        public DiaryDailyModel createFromParcel(Parcel source) {
            return new DiaryDailyModel(source);
        }

        public DiaryDailyModel[] newArray(int size) {
            return new DiaryDailyModel[size];
        }
    };
}
