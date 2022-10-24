package com.example.caremark.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "Images")
data class Image(
    @PrimaryKey(autoGenerate = true) @NonNull var imageId: Int,

    var image: String,
    var date: Int,
)
