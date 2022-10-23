package com.example.caremark.ui

import android.content.Intent
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val handler=Handler(Looper.getMainLooper())
        handler.postDelayed({
            if (accessToken!!.isNotBlank()) {
                startActivity(Intent(this, HomeActivity::class.java))
            }
            else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        },3000)

    }
}


