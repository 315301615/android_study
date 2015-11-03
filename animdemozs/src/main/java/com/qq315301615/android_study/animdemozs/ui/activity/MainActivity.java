package com.qq315301615.android_study.animdemozs.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.qq315301615.android_study.animdemozs.ClickListener.MainActivityListOnItemClickListener;
import com.qq315301615.android_study.animdemozs.R;
import com.qq315301615.android_study.animdemozs.adapter.MainActivityListAdapter;
import com.qq315301615.android_study.animdemozs.bean.MainActivityListItemModel;

public class MainActivity extends AppCompatActivity {
    Context context;
    ListView activity_main_list_activity;
    MainActivityListItemModel[] arryMainActivityListItemModel;
    MainActivityListAdapter mainActivityListAdapter = new MainActivityListAdapter();
    MainActivityListOnItemClickListener mainActivityListOnItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityListOnItemClickListener = new MainActivityListOnItemClickListener(context);
        arryMainActivityListItemModel = new MainActivityListItemModel[]{
                new MainActivityListItemModel(CrossfadeActivity.class, getString(R.string.title_crossfade)),
                new MainActivityListItemModel(CardFlipActivity.class, getString(R.string.title_card_flip)),
                new MainActivityListItemModel(ScreenSlideActivity.class, getString(R.string.title_screen_slide)),
                new MainActivityListItemModel(ZoomActivity.class, getString(R.string.title_zoom)),
                new MainActivityListItemModel(LayoutChangesActivity.class, getString(R.string.title_layout_changes))

        };
        mainActivityListOnItemClickListener.mainActivityListAdapter = mainActivityListAdapter;
        mainActivityListAdapter.arryMainActivityListItemModel = arryMainActivityListItemModel;
        activity_main_list_activity = (ListView) findViewById(R.id.activity_main_list_activity);
        activity_main_list_activity.setAdapter(mainActivityListAdapter);
        activity_main_list_activity.setOnItemClickListener(mainActivityListOnItemClickListener);
    }

}
