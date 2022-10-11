package com.example.caremark.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var response:String,
    @SerializedName("message") var message:String,
    @SerializedName("access_token") var accessToken:String,
    @SerializedName("user_id") var userId:String,
    @SerializedName("profile_id") var profileId:String,

    )
