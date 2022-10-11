package com.example.caremark.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caremark.models.*
import com.example.caremark.Repository.UserRepository
import com.example.caremark.models.RegisterRequest
import com.example.caremark.models.RegisterResponse
import com.example.caremark.models.LoginResponse
import com.example.caremark.models.LoginRequest
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository = UserRepository()
    val loginResponseLivedata = MutableLiveData<LoginResponse>()
    val loginErrorliveData = MutableLiveData<String?>()
    var registerResponseLiveData=MutableLiveData<RegisterResponse>()
    val registerErrorLiveData=MutableLiveData<String?>()
//    var profileResponseLiveData=MutableLiveData<ProfileResponse>()
    val profileErrorLiveData=MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponseLivedata.postValue(response.body())
            }
            else{
                val error=response.errorBody()?.string()
                loginErrorliveData.postValue(error)
                loginErrorliveData.postValue(response.errorBody()?.string())
            }
        }
    }


    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch{
            val response = userRepository.registerUser(registerRequest)
            if(response.isSuccessful){
               registerResponseLiveData.postValue(response.body())
            }
           else{
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error) }
       }
    }

//  fun profileUser(profileRequest: ProfileRequest){
//     viewModelScope.launch{
//          val response = userRepository.profileUser(profileRequest)
//         if(response.isSuccessful){
//             profileResponseLiveData.postValue(response.body())
//           }
//         else{
//         val error = response.errorBody()?.string()
//                profileErrorLiveData.postValue(error)
//                profileErrorLiveData.postValue(response.errorBody()?.string())
//
//           }
//      }
//    }

}