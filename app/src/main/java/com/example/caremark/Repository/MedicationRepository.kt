package com.example.caremark.Repository

import androidx.lifecycle.LiveData
import com.example.caremark.CareMark
import com.example.caremark.Database.CareMarkDb
import com.example.caremark.models.Medication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MedicationRepository {
    val database= CareMarkDb.getDatabase(CareMark.appContext)

    suspend fun saveMedication(medication: Medication){
        withContext(Dispatchers.IO){
            database.MedicationDAO().insertMedication(medication)
        }
    }
    fun getMedicationById(medicationId:Int):LiveData<Medication>{
        return database.MedicationDAO().getMedicationById(medicationId )
    }

    fun getAllMedications():LiveData<List<Medication>>{
        return database.MedicationDAO().getAllMedications()
    }
}
