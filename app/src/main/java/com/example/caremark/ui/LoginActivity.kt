package com.example.caremark.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.caremark.R
import com.example.caremark.ViewModel.UserViewModel
import com.example.caremark.databinding.ActivityLoginBinding
import com.example.caremark.databinding.ActivityOnboardingBinding
import com.example.caremark.models.LoginRequest
import com.example.caremark.models.LoginResponse
import com.example.caremark.utils.Constants

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs=getSharedPreferences("CAREMARK_PREFS", MODE_PRIVATE)


        binding.btnLogin.setOnClickListener{
            validateForm()
            val intent = Intent(this, MedicationSetupActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLivedata.observe(this, Observer {loginResponse->
            saveLoginDetails(loginResponse!!)
            Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, MedicationSetupActivity::class.java))
            finish()
        })
        userViewModel.loginErrorLiveData.observe(this, Observer{ error->
            Toast.makeText(baseContext, error,Toast.LENGTH_LONG).show()
        })
    }



    private fun validateForm() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        var error = false

        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (!error) {
            val loginRequest = LoginRequest(email, password)
            binding.pbLogin.visibility = View.VISIBLE
            userViewModel.loginUser(loginRequest)

//            var loginUser = LoginRequest(email,password)
//            userViewModel.loginUser(loginUser)
//            binding.pbLogin.visibility = View.VISIBLE
//intended change for the progress bar
        }
    }

    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor = sharedPrefs.edit()
        val token = "Bearer ${loginResponse.accessToken}"
        editor.putString(Constants.accessToken, loginResponse.accessToken)
        editor.putString(Constants.userId, loginResponse.userId)
        editor.putString(Constants.profileId, loginResponse.profileId)
        editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
        editor.putString("USER_ID", loginResponse.accessToken)
        editor.putString("USER_ID", loginResponse.userId)
        editor.putString("PROFILE_ID", loginResponse.profileId)
        editor.apply()
    }














        companion object{
        fun getIntent(context: Context):Intent{
            return  Intent(context, LoginActivity::class.java)
        }

    }
    }



