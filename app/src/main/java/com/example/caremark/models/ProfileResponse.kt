package com.example.caremark.models
import com.google.gson.annotations.SerializedName
import java.net.Inet4Address

data class ProfileResponse(
    @SerializedName("firstname") var firstName: String,
    @SerializedName("lastname") var lastName: String,
    var email: String,
)
