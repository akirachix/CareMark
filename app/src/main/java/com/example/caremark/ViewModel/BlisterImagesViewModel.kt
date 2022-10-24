package com.example.caremark.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BlisterImagesViewModel: ViewModel(){
    val ImageRepository= ImageRepository()
    lateinit var ImageLiveData: LiveData<Image>
    lateinit var ImagesLiveData: LiveData<List<Image>>

    fun saveImage(image: Image){
        viewModelScope.launch{
            ImageRepository.saveImage(image)
        }
    }
    fun getAllImages(){
        ImagesLiveData=ImageRepository.getAllImages()
    }

}
