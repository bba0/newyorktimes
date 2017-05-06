package com.example.bba0.newyorktimes.services;

import com.example.bba0.newyorktimes.data.NewYorkTimesData;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by bba0 on 2017. 5. 3..
 */

public interface ApiClientType {
    Observable<Response<NewYorkTimesData>> getStoryList();
}
