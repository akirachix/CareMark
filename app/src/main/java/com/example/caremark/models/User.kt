package com.example.caremark.models

import com.google.gson.annotations.SerializedName
data class User(
    @SerializedName("first_name") var firstName : String,
    @SerializedName("last_name") var lastName : String,
    var userId:String,
    var email:String


)
