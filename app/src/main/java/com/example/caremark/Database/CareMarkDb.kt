package com.example.caremark.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.caremark.models.Medication

@Database(entities = arrayOf(Medication::class), version = 2)
abstract class CareMarkDb : RoomDatabase() {
    abstract fun MedicationDAO(): MedicationDAO

    companion object {
        private var database: CareMarkDb? = null

        fun getDatabase(context: Context): CareMarkDb {
            if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    CareMarkDb::class.java, "CareMarkDb"
                )
                    .fallbackToDestructiveMigration().build()
            }
            return database as CareMarkDb
        }
    }
}