package com.example.caremark.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.caremark.R
import com.example.caremark.ViewModel.UserViewModel
import com.example.caremark.databinding.ActivityCongratulationsBinding
import com.example.caremark.databinding.ActivityForgotpasswordBinding
import com.example.caremark.databinding.ActivityLoginBinding
import com.example.caremark.utils.Constants.Companion.accessToken

class CongratulationsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCongratulationsBinding
//    lateinit var sharedPrefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratulationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val handler= Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        },3000)

    }
}