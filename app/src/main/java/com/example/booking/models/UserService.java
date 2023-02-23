package com.example.booking.models;

import com.example.booking.adapter.LoginRequest;
import com.example.booking.adapter.LoginResponse;
import com.example.booking.adapter.RegisterRequest;
import com.example.booking.adapter.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("user/login/")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
    @POST("user/")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);
}
