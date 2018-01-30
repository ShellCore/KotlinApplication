package com.shellcore.android.kotlinapplication.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.Toast
import com.shellcore.android.kotlinapplication.R
import com.shellcore.android.kotlinapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        val btn = findViewById<Button>(R.id.btnById)
        btn.setOnClickListener {
            Toast.makeText(this, "Click by Id", Toast.LENGTH_SHORT)
                    .show()
        }

        btnByKat.setOnClickListener {
            Toast.makeText(this, "Click by KAT", Toast.LENGTH_SHORT)
                    .show()
        }
    }
}
