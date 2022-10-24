package com.example.caremark.Repository

import androidx.lifecycle.LiveData
import com.example.caremark.CareMark
import com.example.caremark.Database.CareMarkDb
import com.example.caremark.models.BlisterImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepository {
    val database= CareMarkDb.getDatabase(CareMark.appContext)

    suspend fun saveBlisterImage(blisterImage: BlisterImage){
        withContext(Dispatchers.IO){
            database.ImageDAO().insertImage(blisterImage)
        }
    }
    fun getImageById(blisterImageId:Int): LiveData<BlisterImage> {
        return database.ImageDAO().getImageById(blisterImageId)
    }

    fun getAllImages():LiveData<List<BlisterImage>>{
        return database.ImageDAO().getAllImages()
    }
}

