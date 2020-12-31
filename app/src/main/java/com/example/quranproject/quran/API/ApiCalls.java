package com.example.quranproject.quran.API;

import com.example.quranproject.quran.API.Model.RadiosResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiCalls {

    @GET("radio/radio_ar.json")
    Call<RadiosResponse> getAllRadioChannels();
}
