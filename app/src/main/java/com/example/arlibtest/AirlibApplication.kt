package com.example.arlibtest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AirlibApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}