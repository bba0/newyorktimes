package com.example.bba0.newyorktimes.story;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.bba0.newyorktimes.R;
import com.example.bba0.newyorktimes.story_list.StoryListFragment;

/**
 * Created by bba0 on 2017. 5. 6..
 */

public class StoryActivity extends Activity {
    StoryFragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mFragment = new StoryFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.story_contentFrame, mFragment);
        transaction.commit();

        String url = getIntent().getStringExtra("url");
        if (url == null || url.length() == 0) {
            finish();
        }

        mFragment.setData(url);
    }

    @Override
    public void onBackPressed() {
        if (mFragment != null && mFragment.canGoBack()) {
            return;
        }
        finish();
    }
}
