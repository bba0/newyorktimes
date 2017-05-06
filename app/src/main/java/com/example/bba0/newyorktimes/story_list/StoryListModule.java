package com.example.bba0.newyorktimes.story_list;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bba0 on 2017. 5. 5..
 */

@Module
public class StoryListModule {
    StoryListContract.View mView;
    public StoryListModule(StoryListContract.View pView) {
        mView = pView;
    }

    @Provides
    StoryListContract.View provideStoryListContractView() {
        return mView;
    }
}
