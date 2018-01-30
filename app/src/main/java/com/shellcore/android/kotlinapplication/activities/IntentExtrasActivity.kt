package com.shellcore.android.kotlinapplication.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.shellcore.android.kotlinapplication.R
import com.shellcore.android.kotlinapplication.models.Student
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : AppCompatActivity() {

    companion object {
        val NAME_KEY = "name"
        val LAST_NAME_KEY = "lastName"
        val AGE_KEY = "age"
        val DEVELOPER_KEY = "developer"
        val STUDENT_KEY = "student"
    }

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btnBack.setOnClickListener {
            startActivity(Intent(this, IntentsActivity::class.java))
        }

        val isExtraSet = setIntentExtras()
        val isParcelableSet = setParcelableExtras()

        if (!isExtraSet && !isParcelableSet) {
            chkDeveloper.visibility = View.GONE
        }
    }

    private fun setIntentExtras(): Boolean {
        val name = intent.getStringExtra(NAME_KEY)
        val lastName = intent.getStringExtra(LAST_NAME_KEY)
        val age = intent.getIntExtra(AGE_KEY, -1)
        val developer = intent.getBooleanExtra(DEVELOPER_KEY, false)

        if (name != null && lastName != null && age >= 0) {
            txtName.text = name
            txtLastName.text = lastName
            txtAge.text = "$age"
            chkDeveloper.isChecked = developer
            chkDeveloper.text = "Developer"
            return true
        }
        return false
    }

    private fun setParcelableExtras(): Boolean {
        val student = intent.getParcelableExtra<Student>(STUDENT_KEY)
        student?.let {
            txtName.text = student.name
            txtLastName.text = student.lastName
            txtAge.text = "${student.age}"
            chkDeveloper.isChecked = student.developer
            chkDeveloper.text = "Developer"
            return true
        }
        return false
    }
}
