package com.example.caremark.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caremark.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)



        setContentView(binding.root)
        sharedPrefs = getSharedPreferences("CAREMARK_PREFS", MODE_PRIVATE)
        binding.btnLogout.setOnClickListener {
            Logoutrequest()
        }

    }
        fun Logoutrequest() {
            sharedPrefs.edit().clear().apply()
            startActivity(Intent(this, LoginActivity::class.java))


        }


}