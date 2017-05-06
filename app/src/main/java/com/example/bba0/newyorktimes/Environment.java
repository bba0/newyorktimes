package com.example.bba0.newyorktimes;

import com.example.bba0.newyorktimes.services.ApiClientType;
import com.google.gson.Gson;


/**
 * Created by bba0 on 2017. 5. 3..
 */

public class Environment {

    Gson mGson;
    ApiClientType mApiClientType;
    public Environment(Gson gson, ApiClientType apiClientType) {
        mGson = gson;
        mApiClientType = apiClientType;
    }

    public Gson getGson() {
        return mGson;
    }

    public ApiClientType getApiClientType() {
        return mApiClientType;
    }
}
