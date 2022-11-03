package com.example.caremark.api

import com.example.caremark.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/api/register/")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("/api/login/")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>

//    @POST("/profile")
//    suspend fun profile(@Body profileRequest: ProfileRequest):Response<ProfileResponse>
}