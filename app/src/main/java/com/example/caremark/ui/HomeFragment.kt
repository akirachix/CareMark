package com.example.caremark.ui

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.view.iterator
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caremark.R
import com.example.caremark.ViewModel.BlisterImagesViewModel
import com.example.caremark.ViewModel.MedicationViewModel
import com.example.caremark.databinding.FragmentHomeBinding
import com.example.caremark.models.BlisterImage
import com.example.caremark.models.Medication
import com.github.sundeepk.compactcalendarview.domain.Event
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*


class HomeFragment : Fragment() {
    val CAMERA_PERMISSION_CODE = 1000
    val IMAGE_CAPTURE_CODE = 1001
    var imageUri: Uri? = null

    var imageView: ImageView? = null
    lateinit var binding: FragmentHomeBinding
    val medsViewModel: MedicationViewModel by activityViewModels()
    val blisterImagesViewModel: BlisterImagesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        medsViewModel.getAllMedication()
        return binding.root
    }

    private fun requestCameraPermission(): Boolean {
        var permissionGranted = false

        // If system os is Marshmallow or Above, we need to request runtime permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val cameraPermissionNotGranted = checkSelfPermission(
                activity as Context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_DENIED
            if (cameraPermissionNotGranted) {
                val permission = arrayOf(Manifest.permission.CAMERA)

                // Display permission dialog
                requestPermissions(permission, CAMERA_PERMISSION_CODE)
            } else {
                // Permission already granted
                permissionGranted = true
            }
        } else {
            // Android version earlier than M -> no need to request permission
            permissionGranted = true
        }

        return permissionGranted
    }

    // Handle Allow or Deny response from the permission dialog
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode === CAMERA_PERMISSION_CODE) {
            if (grantResults.size === 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission was granted
                openCameraInterface()
            } else {
                // Permission was denied
                showAlert("Camera permission was denied. Unable to take a picture.");
            }
        }
    }

    private fun openCameraInterface() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, R.string.take_picture)
        values.put(MediaStore.Images.Media.DESCRIPTION, R.string.take_picture_description)
        imageUri =
            activity?.contentResolver?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        // Create camera intent
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)

        // Launch intent
        startActivityForResult(intent, IMAGE_CAPTURE_CODE)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Callback from camera intent
        if (resultCode == Activity.RESULT_OK) {
            // Set image captured to image view
           //ar imageUr = imageView?.setImageURI(imageUri).toString()


            val dateTime = LocalDateTime.now()
            blisterImagesViewModel.saveBlisterImage(
                BlisterImage(
                    blisterImageId = 0,
                    blisterImageUri = imageUri.toString(),
                    blisterImageDate = dateTime.toString()
                )
            )
            val intent = Intent(this@HomeFragment.requireContext(),CongratulationsActivity::class.java)
            startActivity(intent)

        } else {
            // Failed to take picture
            showAlert("Failed to take camera picture")
        }
    }

    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(activity as Context)
        builder.setMessage(message)
        builder.setPositiveButton(R.string.ok_button_title, null)

//        binding.rvMeds.setOnClickListener{
//            val intent = Intent(this@HomeFragment.requireContext(),CongratulationsActivity::class.java)
//            startActivity(intent)
//        }

        val dialog = builder.create()
        dialog.show()


    }

    private fun trackVerifications(blisterImages: List<BlisterImage>){

        blisterImages.forEach { image ->image.blisterImageDate
            val formatter= SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val date = formatter.parse(image.blisterImageDate)!!

            val cal = Calendar.getInstance()
            cal.time = date
            cal.timeInMillis
//            val list= listOf(millis)
            val allDates=binding.calendarView2
//            allDates= listOf(millis)
            for (date in allDates){
                date.setBackgroundColor(Color.WHITE)

                Log.d("BlisterImage","${date}")}}
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        medsViewModel.MedicationsLiveData.observe(viewLifecycleOwner, Observer{ meds->
            displayMeds(meds)

        imageView = binding.imgPicture
            var x= blisterImagesViewModel.getAllBlisterImages()
            trackVerifications(x.value?: listOf(BlisterImage(0,"","2022-11-02")))



            binding.btnVerify.setOnClickListener {
            // Request permission
            val permissionGranted = requestCameraPermission()
            if (permissionGranted) {
                // Open the camera interface
                openCameraInterface()
            }
        }
            binding.imgprofile.setOnClickListener {
                val intent = Intent(this@HomeFragment.requireContext(),ProfileActivity::class.java)
                startActivity(intent)
            }

            binding.fabAddMedicine.setOnClickListener {
                val intent = Intent(this@HomeFragment.requireContext(),AddMedicationActivity::class.java)
                startActivity(intent)
            }

        })
    }

    fun displayMeds(medications: List<Medication>) {
        var medsAdapter = MedicationAdapter(medications)
        binding.rvMeds.layoutManager = LinearLayoutManager(context)
        binding.rvMeds.adapter = medsAdapter
    }

}








