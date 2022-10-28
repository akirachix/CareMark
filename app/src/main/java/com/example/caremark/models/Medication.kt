package com.example.caremark.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Medications")
data class Medication(
    @PrimaryKey(autoGenerate = true) @NonNull var medicationId: Int,
    var medicationName: String,
    var time: String,
    var noOfTimes: Int,
    var startDate: String,
    var endDate:String,
    var appointmentDate:String
)

