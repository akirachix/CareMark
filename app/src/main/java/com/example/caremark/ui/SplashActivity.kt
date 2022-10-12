package com.example.caremark.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.caremark.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler=Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent=Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}


