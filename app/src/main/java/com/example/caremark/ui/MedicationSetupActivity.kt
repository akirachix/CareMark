package com.example.caremark.ui

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.caremark.R
import com.example.caremark.ViewModel.MedicationViewModel
import com.example.caremark.databinding.ActivityMedicationSetupBinding
import com.example.caremark.models.Medication
import java.util.*

class MedicationSetupActivity : AppCompatActivity(){
    var hourOfDay=0
    var minute=0

    lateinit var binding: ActivityMedicationSetupBinding
    val medicationViewModel: MedicationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMedicationSetupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMedication()
        getNoOfTimes()
//        getTime()
        getDate()
        SaveMedication()
        getPeriod()
    }


    fun getMedication(){
        val items = listOf("Rifampin (RIF)", "Isoniazid (INH)", "Pyrazinamide (PZA)", "Ethambutol (EMB)")
        val adapter = ArrayAdapter(this, R.layout.list_items, items)
        binding.etName.setAdapter(adapter)
    }

    fun getNoOfTimes(){
        val times = listOf(1,2,3)
        val timesAdapter = ArrayAdapter(this, R.layout.list_items, times)
        binding.etTime.setAdapter(timesAdapter)
    }

    fun getPeriod(){
        val periods = listOf("Morning", "Evening")
        val periodAdapter = ArrayAdapter(this, R.layout.list_items, periods)
        binding.etReminder.setAdapter(periodAdapter)
    }

    fun getDate(){
        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        binding.etStartDate.setOnClickListener{
            val startDate = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                binding.etStartDate.setText("" + dayOfMonth + "- " + month + "-" + year)
            }, year, month, day)
            startDate.datePicker.setMinDate(System.currentTimeMillis() - 1000);
            startDate.show()
        }

        binding.etEndDate.setOnClickListener{
            val endDate = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                binding.etEndDate.setText("" + dayOfMonth + "- " + month + "- " + year)
            }, year, month, day)
            endDate.datePicker.setMinDate(System.currentTimeMillis() - 1000);
            endDate.show()
        }

        binding.etAppointment.setOnClickListener{
            val checkUpDate = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                binding.etAppointment.setText("" + dayOfMonth + " -" + month + "- " + year)
            }, year, month, day)
            checkUpDate.datePicker.setMinDate(System.currentTimeMillis() - 1000);
            checkUpDate.show()
        }



    }

//    fun getTime(){
//        binding.etReminder.setOnClickListener {
//            val curr=Calendar.getInstance()
//            val hour=curr.get(Calendar.HOUR_OF_DAY)
//            val minutes=curr.get(Calendar.MINUTE)

//            TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
//                var amPm = ""
//                var h = 0
//                if(hourOfDay > 12){
//                    h = hourOfDay
//                    amPm = "PM"
//                }else{ 
//                    h = hourOfDay
//                    amPm = "AM"
//                }
//                binding.etReminder.setText("$h:$minute $amPm")
//            }, hour,minutes,false).show()
//        }
//    }
    fun SaveMedication(){
        binding.btnSaveMedicationDetails.setOnClickListener {
            validateAddMedication()
           val intent= Intent(this,ReminderActivity::class.java)
            startActivity(intent)
        }
    }


    fun validateAddMedication(){
        var error = false
        var medicationName=binding.etName.text.toString()
        var time=binding.etReminder.text.toString()
        var noOfTimes=binding.etTime.text.toString()
        var startDate = binding.etStartDate.text.toString()
        var endDate = binding.etEndDate.text.toString()
        var checkUpdate = binding.etAppointment.text.toString()

        if (medicationName.isBlank()){
            binding.etName.error="Enter medication name"
            error=true
        }

        if (time.isBlank()){
            binding.etReminder.error="Medication time required"
            error=true
        }
        if (noOfTimes.isBlank()){
            binding.etTime.error="Enter the number of taking pills in a day"
            error=true
        }
        if (startDate.isBlank()){
            binding.etStartDate.error="Enter the treatment starting date"
            error=true
        }
        if (endDate.isBlank()){
            binding.etEndDate.error="Enter the reminder end day"
            error=true
        }
        if (checkUpdate.isBlank()){
            binding.etAppointment.error="Enter the appointment date"
            error=true
        }

        if(!error){
            var medication= Medication(
                medicationId = 0, medicationName = medicationName,
                time =time,
                noOfTimes =noOfTimes.toInt(),
                startDate =startDate,
                endDate =endDate,
                appointmentDate =checkUpdate)
            medicationViewModel.saveMedication(medication)
        }

    }


}













