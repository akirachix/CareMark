package com.example.caremark.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caremark.Repository.BlisterImagesRepository
import com.example.caremark.models.BlisterImage
import kotlinx.coroutines.launch
import java.util.Date

class BlisterImagesViewModel: ViewModel(){
    val BlisterImagesRepository= BlisterImagesRepository()
    lateinit var BlisterImageLiveData: LiveData<BlisterImage>
    lateinit var BlisterImagesLiveData: LiveData<List<BlisterImage>>

    fun saveBlisterImage(blisterImage: BlisterImage){
        viewModelScope.launch{
            BlisterImagesRepository.saveBlisterImage(blisterImage)
        }
    }
    fun getAllBlisterImages():LiveData<List<BlisterImage>>{
        BlisterImagesLiveData=BlisterImagesRepository.getAllBlisterImages()
        return BlisterImagesLiveData
    }
    fun fetchBlisterImagebyDate(blisterImageDate: String){
        BlisterImageLiveData = BlisterImagesRepository.getBlisterImageByDate(blisterImageDate)
    }

}
