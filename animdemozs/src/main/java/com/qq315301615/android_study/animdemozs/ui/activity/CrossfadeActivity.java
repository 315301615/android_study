package com.qq315301615.android_study.animdemozs.ui.activity;

import android.animation.Animator;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.qq315301615.android_study.animdemozs.R;

public class CrossfadeActivity extends AppCompatActivity {
    private boolean boonContentLoaded;
    private View vContent;
    private View vContentLoadProbar;
    private int intShortAnimationDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfade);
        vContent = findViewById(R.id.sv_content);
        vContentLoadProbar = findViewById(R.id.pb_content);
        vContent.setVisibility(View.GONE);
        intShortAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_crossfade, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:{
                NavUtils.navigateUpTo(CrossfadeActivity.this, new Intent(CrossfadeActivity.this,MainActivity.class));
                return true;
            }
            case R.id.action_toggle:{
                boonContentLoaded = !boonContentLoaded;
                showContentOrLoaddingIndicator(boonContentLoaded);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void showContentOrLoaddingIndicator(boolean boonContentLoaded){
        final View vWillShowView = boonContentLoaded?vContent:vContentLoadProbar;
        final View vWillHideView = boonContentLoaded?vContentLoadProbar:vContent;
        vWillShowView.setAlpha(0f);
        vWillShowView.setVisibility(View.VISIBLE);
        vWillShowView.animate().alpha(1.0f).setDuration(intShortAnimationDuration).setListener(null);
        vWillHideView.animate().alpha(0f).setDuration(intShortAnimationDuration).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                vWillHideView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
