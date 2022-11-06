package com.example.caremark.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.caremark.ViewModel.UserViewModel
import com.example.caremark.databinding.ActivitySignupBinding
import com.example.caremark.models.RegisterRequest

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs=getSharedPreferences("CAREMARK_PREFS", MODE_PRIVATE)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            validateSignupForm()
        }

        binding.tvLogin.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { registerResponse->
            Toast.makeText(baseContext,"Successfully Registered",Toast.LENGTH_LONG).show()

            startActivity(Intent(baseContext,LoginActivity::class.java))
            startActivity(Intent(this@SignupActivity,LoginActivity::class.java))
        })
        userViewModel.registerErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,"Unable to Register",Toast.LENGTH_LONG).show()
        })
    }

    fun validateSignupForm() {
        binding.tilFirstName.error = null
        binding.tilLastName.error = null
        binding.tilEmail.error=null
        binding.tilphonenumber.error=null
        binding.tilPassword.error = null
        var error = false




        var firstName = binding.etFirstname.text.toString()
        if (firstName.isBlank()) {
            binding.tilFirstName.error = "First name is required"
            error = true
        }

        var lastName = binding.etLastname.text.toString()
        if (lastName.isBlank()) {
            binding.tilLastName.error = "Second name is required"
            error = true
        }

        var email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is a required field"
            error = true
        }

        var phoneNumber = binding.etphonenumber.text.toString()
        if (phoneNumber.isBlank()) {
            binding.tilphonenumber.error = "Phone number is a required field"
            error = true
        }

        var password = binding.etPassword.text.toString()
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }

        var confirmPassword = binding.etConfirmPassword.text.toString()
        if (confirmPassword != password) {
            binding.tilConfirmPassword.error = "Password should match"
            error = true
        }

        if (confirmPassword.isBlank()) {
            binding.tilConfirmPassword.error = "Confirm password"
            error = true
        }



        if (!error) {
            val registerRequest = RegisterRequest(firstName,lastName,email,phoneNumber,password)
            userViewModel.registerUser(registerRequest)
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }
//remove start intent, confirm password and check whether it is only registerUser not register,  and check intent passing in login and signup
//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            binding.tilEmail.error = "Not a valid email address"
//            error = true
//        }


























//    companion object{
//        fun getIntent(context: Context):Intent{
//            return  Intent(context, LoginActivity::class.java)
//        }
//
//    }
}