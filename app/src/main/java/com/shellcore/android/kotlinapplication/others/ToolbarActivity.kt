package com.shellcore.android.kotlinapplication.others

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.shellcore.android.kotlinapplication.models.ToolbarInterface

open class ToolbarActivity : AppCompatActivity(), ToolbarInterface {

    protected var _toolbar: Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        _toolbar?.let {
            setSupportActionBar(toolbar)
        }
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }
}
