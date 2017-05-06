package com.example.bba0.newyorktimes;

import android.app.Application;


/**
 * Created by bba0 on 2017. 5. 3..
 */

public class NewYorkTimes_Application extends Application {
    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
