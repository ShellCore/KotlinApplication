package com.shellcore.android.kotlinapplication.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.shellcore.android.kotlinapplication.R
import com.shellcore.android.kotlinapplication.models.Student
import com.shellcore.android.kotlinapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        btnExtras.setOnClickListener { goIntentExtras() }
        btnFlags.setOnClickListener { goIntentFlags() }
        btnObject.setOnClickListener { goIntentObject() }
    }

    private fun goIntentExtras() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra(IntentExtrasActivity.NAME_KEY, "Cesar")
        intent.putExtra(IntentExtrasActivity.LAST_NAME_KEY, "Morales")
        intent.putExtra(IntentExtrasActivity.AGE_KEY, 30)
        intent.putExtra(IntentExtrasActivity.DEVELOPER_KEY, true)
        startActivity(intent)
    }

    private fun goIntentFlags() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY // No guarda el activity en el stack
//        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION // No animación
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Limpia el stack actual
        startActivity(intent)
//        finish() // Destruye éste activity que entre en el stack
    }
    private fun goIntentObject() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Jorge", "Hernández", 35, false)
        intent.putExtra(IntentExtrasActivity.STUDENT_KEY, student)
        startActivity(intent)
    }

}
