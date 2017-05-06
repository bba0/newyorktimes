package com.example.bba0.newyorktimes.services;

import com.example.bba0.newyorktimes.data.NewYorkTimesData;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by bba0 on 2017. 5. 3..
 */

public class ApiClient implements ApiClientType{
    private final ApiService mService;
    public ApiClient(ApiService pService) {
        mService = pService;
    }

    @Override
    public Observable<Response<NewYorkTimesData>> getStoryList() {
        return mService.getStoryList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
