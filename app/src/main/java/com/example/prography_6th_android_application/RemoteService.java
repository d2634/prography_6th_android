package com.example.prography_6th_android_application;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RemoteService {
    @GET("/films")
    Call<List<movies>> getMovie();
}
