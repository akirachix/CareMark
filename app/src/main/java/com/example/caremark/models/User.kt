package com.example.caremark.models

import com.google.gson.annotations.SerializedName
data class User(
    @SerializedName("firstname") var firstName: String,
    @SerializedName("lastname") var lastName: String,
    var email: String,
    @SerializedName("phonenumber") var phoneNumber: String,
    var password: String,
    var userId:String,
)
