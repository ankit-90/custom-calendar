package com.calendar.base

import android.app.Application
import com.calendar.BuildConfig
import timber.log.Timber

class BaseApp:Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

    }



}