package com.shellcore.android.kotlinapplication

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Hello from the toast", Toast.LENGTH_LONG)
                .show()

        Snackbar.make(container, "Hello from the Snackbar", Snackbar.LENGTH_SHORT)
                .show()

        Snackbar.make(container, "Hello with action", Snackbar.LENGTH_INDEFINITE)
                .setAction("Close") {
                    Snackbar.make(container, "Email has been restored", Snackbar.LENGTH_SHORT)
                            .show()
                }
                .show()
    }
}
