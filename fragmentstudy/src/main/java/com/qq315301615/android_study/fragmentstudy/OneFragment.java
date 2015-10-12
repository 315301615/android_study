package com.qq315301615.android_study.fragmentstudy;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class OneFragment extends Fragment {
    EditText fragment_one_et_msg;
    EditTextListener editTextListener ;
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
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        fragment_one_et_msg = (EditText) rootView.findViewById(R.id.fragment_one_et_msg);
        fragment_one_et_msg.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextListener != null) {
                    editTextListener.onTextChange(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return rootView;
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

    public void setEditTextListener(EditTextListener editTextListener) {
        this.editTextListener = editTextListener;
    }

    /**
     * 文字改变
     */
    public interface EditTextListener {
        public void onTextChange(String strMsg);
    }
}
