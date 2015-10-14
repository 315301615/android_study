package com.qq315301615.android_study.sqlite.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.qq315301615.android_study.sqlite.R;
import com.qq315301615.android_study.sqlite.ui.fragment.DiaryContentFragment;
import com.qq315301615.android_study.sqlite.ui.fragment.DiaryListFragment;

/**
 * diary main page
 * has two fragment,one list one conentet
 */
public class MainActivity extends AppCompatActivity implements DiaryListFragment.OnFragmentInteractionListener,DiaryContentFragment.OnFragmentInteractionListener{
    MainActivity mainActivity;
    final DiaryListFragment itemFragment = new DiaryListFragment();
    final DiaryContentFragment diaryContentFragment = new DiaryContentFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
       getFragmentManager().beginTransaction().add(R.id.main_acy_frt_diary_list, itemFragment).commit();
       getFragmentManager().beginTransaction().add(R.id.main_acy_frt_diary_content, diaryContentFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.acy_main_acr, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //add button clicked
            case R.id.acy_main_acr_button_add_diary:
                break;
            //delete button clicked
            case R.id.acy_main_acr_button_delete_diary:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }
}
