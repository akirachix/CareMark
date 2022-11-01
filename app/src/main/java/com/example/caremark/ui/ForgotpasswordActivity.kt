package com.example.caremark.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caremark.databinding.ActivityForgotpasswordBinding

class ForgotpasswordActivity : AppCompatActivity() {
    lateinit var binding: ActivityForgotpasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsubmit.setOnClickListener {
//            val emaill:String = etforgotemail.text.toString().trim{it <= ''}
        }



    }

}