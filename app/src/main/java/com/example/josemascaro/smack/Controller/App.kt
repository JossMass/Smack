package com.example.josemascaro.smack.Controller

import android.app.Application
import com.example.josemascaro.smack.Utilities.SharedPrefs

/**
 * Created by josemascaro on 3/16/20.
 */
class App : Application() {

    companion object {
        lateinit var prefs: SharedPrefs
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }
}