package com.qq315301615.android_study.sqlite.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qq315301615.android_study.sqlite.R;

public class DiaryContentFragment extends Fragment {

    public static DiaryContentFragment newInstance() {
        DiaryContentFragment fragment = new DiaryContentFragment();
        return fragment;
    }

    public DiaryContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary_content, container, false);
    }



    @Override
    public void onDetach() {
        super.onDetach();

    }

}
