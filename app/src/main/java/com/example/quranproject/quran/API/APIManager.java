package com.example.quranproject.quran.API;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {

    private static Retrofit retrofitInstance;

    private static Retrofit getInstance() {
        if (retrofitInstance == null) {//create
            HttpLoggingInterceptor loggingInterceptor =
                    new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            Log.e("api", message);
                        }
                    });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl("http://mp3quran.net/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofitInstance;
    }

    public static ApiCalls getApis() {
        ApiCalls apiCalls = getInstance().create(ApiCalls.class);
        return apiCalls;
    }

}
