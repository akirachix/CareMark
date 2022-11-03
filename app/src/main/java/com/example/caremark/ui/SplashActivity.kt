package com.example.caremark.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.caremark.R
import com.example.caremark.databinding.ActivityMedicationSetupBinding
import com.example.caremark.databinding.ActivitySplashBinding
import com.example.caremark.utils.Constants.Companion.accessToken

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs = getSharedPreferences("CAREMARK_PREFS", MODE_PRIVATE)
        val accessToken = sharedPrefs.getString("ACCESS_TOKEN","")
        val handler=Handler(Looper.getMainLooper())
        handler.postDelayed({
            if (accessToken!!.isNotBlank()) {
                startActivity(Intent(this, OnboardingActivity::class.java))
            }
            else {

            }
            finish()
        },3000)

    }





}


