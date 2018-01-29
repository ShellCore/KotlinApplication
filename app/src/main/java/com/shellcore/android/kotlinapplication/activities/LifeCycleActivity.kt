package com.shellcore.android.kotlinapplication.activities

import android.os.Bundle
import com.shellcore.android.kotlinapplication.R

class LifeCycleActivity : LifeCycleEventsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onStart() {
        super.onStart()

    }
}
