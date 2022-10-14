package com.example.caremark.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caremark.Repository.MedicationRepository
import com.example.caremark.models.Medication
import kotlinx.coroutines.launch

class MedicationViewModel:ViewModel (){
    val MedicationRepository=MedicationRepository()
    lateinit var MedicationLiveData:LiveData<Medication>
    lateinit var MedicationsLiveData: LiveData<List<Medication>>

    fun saveMedication(medication: Medication){
        viewModelScope.launch{
            MedicationRepository.saveMedication(medication)
        }
    }
    fun fetchMedicationbyid(medicationId:Int){
       MedicationLiveData=MedicationRepository.getMedicationById(medicationId)
    }
    fun getAllMedication(){
        MedicationsLiveData=MedicationRepository.getAllMedications()
    }

}