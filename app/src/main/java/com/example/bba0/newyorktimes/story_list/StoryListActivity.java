package com.example.bba0.newyorktimes.story_list;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.bba0.newyorktimes.NewYorkTimes_Application;
import com.example.bba0.newyorktimes.R;

import javax.inject.Inject;

public class StoryListActivity extends Activity {
    @Inject StoryListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);

        StoryListFragment fragment = new StoryListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.storylist_contentFrame, fragment);
        transaction.commit();

        DaggerStoryListComponent.builder()
                .storyListModule(new StoryListModule(fragment))
                .appComponent(((NewYorkTimes_Application)getApplication()).getAppComponent())
                .build().inject(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
