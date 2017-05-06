package com.example.bba0.newyorktimes.story_list;

import android.util.Log;

import com.example.bba0.newyorktimes.Environment;
import com.example.bba0.newyorktimes.data.NewYorkTimesData;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import retrofit2.Response;

/**
 * Created by bba0 on 2017. 5. 5..
 */

public class StoryListPresenter implements StoryListContract.Presenter {
    String TAG = "lol";
    StoryListContract.View mView;
    Environment mEnvironment;

    @Inject
    StoryListPresenter(StoryListContract.View pView, Environment pEnvironment) {
        mView = pView;
        mEnvironment = pEnvironment;
    }

    @Inject
    void setupPresenter() {
        mView.setPresenter(this);
    }

    @Override
    public void getStoryList() {
        mEnvironment.getApiClientType().getStoryList()
        .subscribe(new Consumer<Response<NewYorkTimesData>>() {
            @Override
            public void accept(Response<NewYorkTimesData> newYorkTimesDataResponse) throws Exception {
                Log.d(TAG, "accept: " + newYorkTimesDataResponse.body().toString());
                mView.setStoryList(newYorkTimesDataResponse.body());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, "getStoryList err:" + throwable.getMessage(), throwable);
                mView.toast("NETWORK ERROR");
            }
        });
    }
}
