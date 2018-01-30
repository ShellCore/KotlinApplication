package com.shellcore.android.kotlinapplication.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.shellcore.android.kotlinapplication.R
import com.shellcore.android.kotlinapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)
    }
}
