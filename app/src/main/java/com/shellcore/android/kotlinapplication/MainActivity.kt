package com.shellcore.android.kotlinapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.shellcore.android.kotlinapplication.activities.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMessages()

        btnCycle.setOnClickListener { goToClickEventsActivity() }
        btnEvents.setOnClickListener { goToExtensionFunctionsActivity() }
        btnExtensions.setOnClickListener { goToIntentsActivity() }
        btnPicasso.setOnClickListener { goToKotlinAndroidExtensionsActivity() }
        btnListView.setOnClickListener { goToLifeCycleActivity() }
        btnIntents.setOnClickListener { goToListViewActivity() }
        btnPermissions.setOnClickListener { goToPermissionsActivity() }
        btnSharedPreferences.setOnClickListener { goToPicassoActivity() }
        btnExtensionFunctions.setOnClickListener { goToSharedPreferencesActivity() }
    }

    private fun showMessages() {
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

    fun goToClickEventsActivity() = startActivity(Intent(this, ClickEventsActivity::class.java))
    fun goToExtensionFunctionsActivity() = startActivity(Intent(this, ExtensionFunctionsActivity::class.java))
    fun goToIntentsActivity() = startActivity(Intent(this, IntentsActivity::class.java))
    fun goToKotlinAndroidExtensionsActivity() = startActivity(Intent(this, KotlinAndroidExtensionsActivity::class.java))
    fun goToLifeCycleActivity() = startActivity(Intent(this, LifeCycleActivity::class.java))
    fun goToListViewActivity() = startActivity(Intent(this, ListViewActivity::class.java))
    fun goToPermissionsActivity() = startActivity(Intent(this, PermissionsActivity::class.java))
    fun goToPicassoActivity() = startActivity(Intent(this, PicassoActivity::class.java))
    fun goToSharedPreferencesActivity() = startActivity(Intent(this, SharedPreferencesActivity::class.java))
}
