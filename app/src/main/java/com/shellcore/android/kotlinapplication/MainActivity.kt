package com.shellcore.android.kotlinapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.shellcore.android.kotlinapplication.activities.*
import com.shellcore.android.kotlinapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMessages()

        toolbarToLoad(toolbar as Toolbar)

        btnCycle.setOnClickListener { goToLifeCycleActivity() }
        btnEvents.setOnClickListener { goToClickEventsActivity() }
        btnExtensions.setOnClickListener { goToKotlinAndroidExtensionsActivity() }
        btnPicasso.setOnClickListener { goToPicassoActivity() }
        btnListView.setOnClickListener { goToListViewActivity() }
        btnIntents.setOnClickListener { goToIntentsActivity() }
        btnPermissions.setOnClickListener { goToPermissionsActivity() }
        btnSharedPreferences.setOnClickListener { goToSharedPreferencesActivity() }
        btnExtensionFunctions.setOnClickListener { goToExtensionFunctionsActivity() }
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
