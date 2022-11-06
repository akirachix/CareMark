package com.example.caremark.Repository

import com.example.caremark.api.ApiClient
import com.example.caremark.api.ApiInterface
import com.example.caremark.models.LoginRequest
import com.example.caremark.models.ProfileRequest
//import com.example.caremark.models.ProfileRequest
import com.example.caremark.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class UserRepository {

    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest)=
        withContext(Dispatchers.IO) {
            return@withContext apiClient.login(loginRequest)
        }

    suspend fun registerUser(registerRequest: RegisterRequest)=
        withContext(Dispatchers.IO) {
            return@withContext apiClient.registerUser(registerRequest)
        }

    suspend fun profileUser(profileRequest: ProfileRequest)=
        withContext(Dispatchers.IO) {
            return@withContext apiClient.profile(profileRequest)
        }


}