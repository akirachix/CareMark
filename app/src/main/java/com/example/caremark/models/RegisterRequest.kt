package com.example.caremark.models
import com.google.gson.annotations.SerializedName
data class RegisterRequest(
    @SerializedName("firstname") var firstName: String,
    @SerializedName("lastname") var lastName: String,
    var email: String,
    @SerializedName("phonenumber") var phoneNumber: String,
    var password: String,
//    val confirmPassword: String


)
