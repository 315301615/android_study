package com.qq315301615.android_study.fragmentstudy;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TwoFragment extends Fragment {
    TextView fragment_two_tv_msg;
    OnFragmentOneChange onFragmentOneChange = new OnFragmentOneChange();
    public static TwoFragment newInstance(String param1, String param2) {
        TwoFragment fragment = new TwoFragment();
        return fragment;
    }

    public TwoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two,container, false);
        fragment_two_tv_msg = (TextView) rootView.findViewById(R.id.fragment_two_tv_msg);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }


    @Override
    public void onDetach() {
        super.onDetach();

    }

    public OnFragmentOneChange getOnFragmentOneChange() {
        return onFragmentOneChange;
    }

    public class OnFragmentOneChange implements MainActivity.RemaindFragmentTwoChange{
        @Override
        public void onTextChange(String strMsg) {
            if(TextUtils.isEmpty(strMsg)){
                fragment_two_tv_msg.setText(R.string.two_fragment_hellostring);
            }else{
                fragment_two_tv_msg.setText(getString(R.string.two_fragment_hellostring)+":"+strMsg);
            }
        }
    }
}
