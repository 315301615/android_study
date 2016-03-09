package com.example.mvp1;

import android.databinding.DataBindingUtil;
import android.databinding.tool.DataBindingBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvp1.bean.User;
import com.example.mvp1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("zhang","shuai");
        mainBinding.setUser(user);
    }
}
