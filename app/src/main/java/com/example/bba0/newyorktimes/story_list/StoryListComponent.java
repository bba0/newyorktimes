package com.example.bba0.newyorktimes.story_list;

import com.example.bba0.newyorktimes.AppComponent;
import com.example.bba0.newyorktimes.util.ActivityScoped;

import dagger.Component;

/**
 * Created by bba0 on 2017. 5. 5..
 */

@ActivityScoped
@Component(modules = StoryListModule.class, dependencies = AppComponent.class)
public interface StoryListComponent {
    void inject(StoryListActivity activity);
}
