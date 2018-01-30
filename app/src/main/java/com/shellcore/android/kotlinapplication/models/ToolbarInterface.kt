package com.shellcore.android.kotlinapplication.models

import android.support.v7.widget.Toolbar

/**
 * Created by MOGC on 30/01/2018.
 */
interface ToolbarInterface {
    fun toolbarToLoad(toolbar: Toolbar?)
    fun enableHomeDisplay(value: Boolean)
}