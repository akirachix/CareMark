package com.example.caremark

import android.app.Application
import android.content.Context

class CareMark : Application() {
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
    }
}