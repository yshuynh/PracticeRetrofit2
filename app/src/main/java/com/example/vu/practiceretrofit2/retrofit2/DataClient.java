package com.example.vu.practiceretrofit2.retrofit2;

import com.example.vu.practiceretrofit2.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface DataClient {

    @GET("users")
    Call<List<User>> GetUserList();
}
