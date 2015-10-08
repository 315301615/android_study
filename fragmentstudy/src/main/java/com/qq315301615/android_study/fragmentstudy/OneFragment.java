package com.qq315301615.android_study.fragmentstudy;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OneFragment extends Fragment {

    public static OneFragment newInstance(String param1, String param2) {
        OneFragment fragment = new OneFragment();

        return fragment;
    }

    public OneFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
    @Override
    public void onDetach() {
        super.onDetach();

    }

    /**
     * fragment 事件接口
     */
    public interface FragmentEventInterface{
        public void onEvent(String stringMsg);
    }
}
