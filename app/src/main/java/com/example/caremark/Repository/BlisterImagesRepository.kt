package com.example.caremark.Repository

import androidx.lifecycle.LiveData
import com.example.caremark.CareMark
import com.example.caremark.Database.CareMarkDb
import com.example.caremark.models.BlisterImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BlisterImagesRepository {
    val database= CareMarkDb.getDatabase(CareMark.appContext)

    suspend fun saveBlisterImage(blisterImage: BlisterImage){
        withContext(Dispatchers.IO){
            database.BlisterImagesDAO().insertBlisterImage(blisterImage)
        }
    }
    fun getBlisterImageByDate(blisterImageDate:Long): LiveData<BlisterImage> {
        return database.BlisterImagesDAO().getBlisterImageByDate(blisterImageDate)
    }

    fun getAllBlisterImages():LiveData<List<BlisterImage>>{
        return database.BlisterImagesDAO().getAllBlisterImages()
    }
}

