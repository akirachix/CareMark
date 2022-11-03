package com.example.caremark.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date


@Entity (tableName = "BlisterImages")
data class BlisterImage(
    @PrimaryKey(autoGenerate = true) @NonNull var blisterImageId: Int,

    var blisterImageUri: String,
    @ColumnInfo(name = "blisterImageDate", defaultValue = "(strftime('%s','now','localtime'))")
    val blisterImageDate: String,
)
