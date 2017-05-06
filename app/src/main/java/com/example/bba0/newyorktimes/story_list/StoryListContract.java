package com.example.bba0.newyorktimes.story_list;

import com.example.bba0.newyorktimes.base.BasePresenter;
import com.example.bba0.newyorktimes.base.BaseView;
import com.example.bba0.newyorktimes.data.NewYorkTimesData;

import java.util.ArrayList;

/**
 * Created by bba0 on 2017. 5. 5..
 */

public interface StoryListContract {
    interface View extends BaseView<Presenter> {
        void setStoryList(NewYorkTimesData pData);
        void toast(String s);
        void setSwipeRefresh(boolean b);
    }

    interface Presenter extends BasePresenter {
        void getStoryList();
    }
}
