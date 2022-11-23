package com.example.caremark.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.example.caremark.R
import com.example.caremark.ViewModel.MedicationViewModel
import com.example.caremark.databinding.ActivityAddMedicationBinding
import com.example.caremark.databinding.ActivityMedicationSetupBinding
import com.example.caremark.models.BlisterImage
import com.example.caremark.models.Medication
import java.util.*

class AddMedicationActivity : AppCompatActivity() {
    var hourOfDay=0
    var minute=0
    lateinit var binding:ActivityAddMedicationBinding
    val medsViewModel: MedicationViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddMedicationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMedication()
        getNoOfTimes()
        getDate()
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



    override fun onResume() {
        super.onResume()
        binding.btnSaveMedicationDetails.setOnClickListener {
            validateAddcontact()
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
        }

    }

//    fun convertToInt(string:String): Int {
//        var times=string
//        var saved = times.toInt()
//        return saved
//    }
    fun validateAddcontact(){
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
            binding.dropdownTimes.error="Enter the number of taking pills in a day"
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
            startActivity(Intent(this, HomeActivity::class.java))
            var medication= Medication(
                medicationId = 0, medicationName = medicationName,
                time =time,
                noOfTimes =noOfTimes.toInt(),
                startDate =startDate,
                endDate =endDate,
                appointmentDate =checkUpdate)
            medsViewModel.saveMedication(medication)
        }

    }

}
