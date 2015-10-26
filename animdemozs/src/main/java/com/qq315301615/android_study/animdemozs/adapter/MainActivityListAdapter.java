package com.qq315301615.android_study.animdemozs.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qq315301615.android_study.animdemozs.CustomApplication;
import com.qq315301615.android_study.animdemozs.R;
import com.qq315301615.android_study.animdemozs.bean.MainActivityListItemModel;

/**
 * Created by 123 on 2015/10/26.
 */
public class MainActivityListAdapter extends BaseAdapter{
    public MainActivityListItemModel[] arryMainActivityListItemModel;
    public MainActivityListItemModel mainActivityListItemModel;
    ViewHolder viewHolder;
    @Override
    public int getCount() {
        int intCount = 0;
        if(arryMainActivityListItemModel!=null){
            intCount = arryMainActivityListItemModel.length;
        }
        return intCount;
    }

    @Override
    public Object getItem(int position) {
        return arryMainActivityListItemModel[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mainActivityListItemModel = (MainActivityListItemModel) getItem(position);
        if(convertView==null){
            convertView = View.inflate(CustomApplication.getInstance(), R.layout.item_main_activity_list, null);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTitle.setText(mainActivityListItemModel.toString());
        return convertView;
    }
    public class ViewHolder{
        public TextView tvTitle;
    }
}
