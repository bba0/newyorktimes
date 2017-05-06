package com.example.bba0.newyorktimes;

import android.support.annotation.NonNull;

import com.example.bba0.newyorktimes.services.ApiClient;
import com.example.bba0.newyorktimes.services.ApiClientType;
import com.example.bba0.newyorktimes.services.ApiService;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bba0 on 2017. 5. 3..
 */

@Singleton
@Module
public class AppModule {
    private final NewYorkTimes_Application mApp;
    @Singleton
    public AppModule(NewYorkTimes_Application pApp) {
        mApp = pApp;
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(httpLoggingInterceptor);
        return builder.build();
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    @NonNull
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
    @Provides
    @Singleton
    @NonNull
    ApiClientType provideApiClientType(final @NonNull ApiService apiService) {
        return new ApiClient(apiService);
    }

    @Provides
    @Singleton
    @NonNull
    ApiService provideApiService(@NonNull Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    @NonNull Retrofit provideApiRetrofit(final @NonNull Gson gson,
                                         final @NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.nytimes.com/svc/topstories/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    Environment providesEnvironment(Gson gson, ApiClientType apiClient) {
        return new Environment(gson, apiClient);
    }

}
