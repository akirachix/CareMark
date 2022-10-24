package com.example.caremark.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.caremark.models.BlisterImage


@Dao
interface BlisterImagesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBlisterImage(blisterImage: BlisterImage)
    @Query("SELECT * FROM BlisterImages")
    fun getAllBlisterImages(): LiveData<List<BlisterImage>>
    @Query("SELECT * FROM BlisterImages WHERE blisterImageDate = :blisterImageDate")
    fun getBlisterImageByDate(blisterImageDate: Long): LiveData<BlisterImage>
}
