package com.example.bba0.newyorktimes.services;

import com.example.bba0.newyorktimes.data.NewYorkTimesData;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by bba0 on 2017. 5. 3..
 */

public interface ApiService {
    @GET("home.json?api-key=cf23f0334a174fff975fc2400ccbfdd9")
    Observable<Response<NewYorkTimesData>> getStoryList();
}
