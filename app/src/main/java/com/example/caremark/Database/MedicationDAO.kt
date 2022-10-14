package com.example.caremark.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.caremark.models.Medication

@Dao
interface MedicationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedication(medication:Medication)
    @Query("SELECT * FROM Medications")
    fun getAllMedications(): LiveData<List<Medication>>
    @Query("SELECT * FROM Medications WHERE medicationId = :medicationId")
    fun getMedicationById(medicationId: Int): LiveData<Medication>
}