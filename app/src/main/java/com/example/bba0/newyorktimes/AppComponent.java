package com.example.bba0.newyorktimes;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bba0 on 2017. 5. 3..
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Environment getEnvronment();
}
