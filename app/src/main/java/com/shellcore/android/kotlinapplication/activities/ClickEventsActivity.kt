package com.shellcore.android.kotlinapplication.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.shellcore.android.kotlinapplication.R
import kotlinx.android.synthetic.main.activity_click_events.*

class ClickEventsActivity : AppCompatActivity(), View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        clickInLine()

        btnClickMulti1.setOnLongClickListener(this)
        btnClickMulti2.setOnLongClickListener(this)
        btnClickMulti3.setOnLongClickListener(this)
    }

    fun xmlClick(view : View) {
        Toast.makeText(this, "Click by XML!", Toast.LENGTH_SHORT)
                .show()
    }

    private fun clickInLine() {
        btnClickInline.setOnClickListener {
            Toast.makeText(this, "Click in Line", Toast.LENGTH_SHORT)
                    .show()
        }
    }

    override fun onLongClick(v: View): Boolean {
        when (v.id) {
            R.id.btnClickMulti1 -> {
                Toast.makeText(this, "Click Multi 1", Toast.LENGTH_SHORT)
                        .show()
            }
            R.id.btnClickMulti2 -> {
                Toast.makeText(this, "Click Multi 2", Toast.LENGTH_SHORT)
                        .show()
            }
            R.id.btnClickMulti3 -> {
                Toast.makeText(this, "Click Multi 3", Toast.LENGTH_SHORT)
                        .show()
            }

        }
        return true
    }
}
