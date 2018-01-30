package com.shellcore.android.kotlinapplication.others

import android.content.Context

/**
 * Created by MOGC on 30/01/2018.
 */
class MySharedPreferences(context: Context) {

    private val fileName = "mis_preferencias"
    private val prefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    var name: String
        get() = prefs.getString("name", "")
        set(value) = prefs.edit().putString("name", value).apply()

    var age: Int
        get() = prefs.getInt("age", -1)
        set(value) = prefs.edit().putInt("age", value).apply()
}