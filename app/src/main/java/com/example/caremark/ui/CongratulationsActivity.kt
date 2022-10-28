package com.example.caremark.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.caremark.R
import com.example.caremark.ViewModel.UserViewModel
import com.example.caremark.databinding.ActivityCongratulationsBinding
import com.example.caremark.databinding.ActivityLoginBinding

class CongratulationsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCongratulationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityCongratulationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}