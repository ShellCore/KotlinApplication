package com.shellcore.android.kotlinapplication.app

import android.app.Application
import com.shellcore.android.kotlinapplication.others.MySharedPreferences

val preferences: MySharedPreferences by lazy { MyApp.prefs!! }

/**
 * Created by MOGC on 30/01/2018.
 */
class MyApp: Application() {

    companion object {
        var prefs: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)
    }
}