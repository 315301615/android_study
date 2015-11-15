package com.example.zhangshuai.android_study.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhanglin on 15/11/15.
 */
public class VPFragment extends Fragment {
    public static final String TEXT_KEY = "TEXT_KEY";
    @Bind(R.id.tv_fragment)
    TextView text ;

    public VPFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment_vp, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        text.setText(bundle.getString(TEXT_KEY));
        return view;
    }
}
