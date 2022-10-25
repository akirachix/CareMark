package com.example.caremark.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.caremark.ViewModel.MedicationViewModel
import com.example.caremark.databinding.ActivityAddMedicationBinding
import com.example.caremark.databinding.ActivityMedicationSetupBinding
import com.example.caremark.models.Medication
import java.util.*

class AddMedicationActivity : AppCompatActivity() {

    lateinit var binding:ActivityAddMedicationBinding
    val medsViewModel: MedicationViewModel by viewModels()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddMedicationBinding.inflate(layoutInflater)
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
            val curr= Calendar.getInstance()
            val hour=curr.get(Calendar.HOUR_OF_DAY)
            val minutes=curr.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.etTime.setText("$hourOfDay:$minute")
            }, hour,minutes,false).show()
        }

    }
    override fun onResume() {
        super.onResume()
        binding.btnSaveMedicationDetails.setOnClickListener {
            validateAddcontact()
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
        }

    }
    fun convertToInt(string:String): Int {
        var doses=binding.etDoses.text.toString()
        var saved = doses.toInt()
        return saved
    }
    fun validateAddcontact(){

        var hourOfDay=0
        var minute=0
        var error = false
        var medicationName=binding.editTextTextPersonName.text.toString()
        var doses=binding.etDoses.text.toString()
        var time=binding.etTime.text.toString()
        var noOfTimes=binding.etNoOfTimes.text.toString()
        var startDate = binding.etStartDate.text.toString()
        var endDate = binding.etEndDate.text.toString()
        var appointmentDate = binding.etAppointment.text.toString()

        if (medicationName.isBlank()){
            binding.editTextTextPersonName.error="Enter medication name"
            error=true
        }
        if (doses.isBlank()){
            binding.etDoses.error="Enter doses"
            error=true
        }
        if (time.isBlank()){
            binding.etTime.error="Medication time required"
            error=true
        }
        if (noOfTimes.isBlank()){
            binding.etNoOfTimes.error="Enter the number of taking pills in a day"
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
        if (appointmentDate.isBlank()){
            binding.etAppointment.error="Enter the appointment date"
            error=true
        }
        if(!error){
            startActivity(Intent(this, HomeActivity::class.java))
            var medication= Medication(
                medicationId = 0, medicationName = medicationName,
                doses =convertToInt(doses),
                time =convertToInt(time),
                noOfTimes =convertToInt(noOfTimes),
                startDate =startDate,
                endDate =endDate,
                appointmentDate =appointmentDate)
            medsViewModel.saveMedication(medication)
        }

    }

}