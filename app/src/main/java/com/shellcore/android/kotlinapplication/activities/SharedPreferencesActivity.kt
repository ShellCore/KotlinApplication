package com.shellcore.android.kotlinapplication.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.shellcore.android.kotlinapplication.R
import com.shellcore.android.kotlinapplication.app.preferences
import com.shellcore.android.kotlinapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        btnSave.setOnClickListener {
            setValuesSharedPreferences()
            cleanEditTexts()
            getValuesSharedPreferences()
        }
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences() {
        if (preferences.name.isNotEmpty() && preferences.age >= 0) {
            txtShared.text = "Welcome ${preferences.name}, your age is ${preferences.age}."
        } else {
            txtShared.text = "Welcome. Please save your name and your age."
        }
    }

    private fun setValuesSharedPreferences() {
        if (edtName.text.toString().isNotEmpty() && edtAge.text.toString().isNotEmpty()) {
            preferences.name = edtName.text.toString()
            preferences.age = edtAge.text.toString().toInt()

            Toast.makeText(this, "Values has been saved successfully!", Toast.LENGTH_SHORT)
                    .show()
        } else {
            Toast.makeText(this, "Please fill the name and the age before saving.", Toast.LENGTH_SHORT)
                    .show()
        }
    }

    private fun cleanEditTexts() {
        edtName.text.clear()
        edtAge.text.clear()
    }
}
