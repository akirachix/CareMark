package com.example.caremark.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.TimePicker
import androidx.activity.viewModels
import com.example.caremark.R
import com.example.caremark.ViewModel.UserViewModel
import com.example.caremark.databinding.ActivityHomeBinding.inflate
import com.example.caremark.databinding.ActivityLoginBinding.inflate
import com.example.caremark.databinding.ActivityMedicationSetupBinding
import com.example.caremark.databinding.ActivityOnboardingBinding.inflate
import com.example.caremark.databinding.ActivitySignupBinding.inflate


import java.util.*

class MedicationSetupActivity : AppCompatActivity(){
    var hourOfDay=0
    var minute=0
    lateinit var binding:ActivityMedicationSetupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMedicationSetupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDate()
        getTime()

    }


    fun getDate(){
        val c = Calendar.getInstance()

       val year = c.get(Calendar.YEAR)
         val month = c.get(Calendar.MONTH)
         val day = c.get(Calendar.DAY_OF_MONTH)

        binding.imgStartDate.setOnClickListener{
            val startDate = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                binding.etStartDate.setText("" + dayOfMonth + " " + month + ", " + year)
            }, year, month, day)
            startDate.show()
        }

        binding.imgEndDate.setOnClickListener{
            val endDate = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                binding.etEndDate.setText("" + dayOfMonth + " " + month + ", " + year)
            }, year, month, day)
            endDate.show()
        }

        binding.imgAppointment.setOnClickListener{
            val appointmentDate = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                binding.etAppointment.setText("" + dayOfMonth + " " + month + ", " + year)
            }, year, month, day)
            appointmentDate.show()
        }

    }


    fun getTime(){
        binding.imgTime.setOnClickListener {
            val curr=Calendar.getInstance()
            val hour=curr.get(Calendar.HOUR_OF_DAY)
            val minutes=curr.get(Calendar.MINUTE)

            TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.etTime.setText("$hourOfDay:$minute")
            }, hour,minutes,false).show()
        }

    }









}

class ActivityMedicationSetupBinding {

}
