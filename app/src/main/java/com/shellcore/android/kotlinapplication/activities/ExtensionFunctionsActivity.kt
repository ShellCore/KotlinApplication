package com.shellcore.android.kotlinapplication.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.shellcore.android.kotlinapplication.MainActivity
import com.shellcore.android.kotlinapplication.R
import com.shellcore.android.kotlinapplication.others.*
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        btnToast.setOnClickListener {
            toast("I love extension functions!")
        }

        btnSnackbar.setOnClickListener {
            snackbar("I love extension functions", action = "Undo") {
                toast("Undo!!")
            }
        }

        btnLoadByUrl.setOnClickListener {
            imgViewLoadedByUrl.loadByUrl("https://d3ieicw58ybon5.cloudfront.net/ex/480.480/shop/product/b61604a7ba654c12ad129b1ba97291b9.jpg")
        }

        btnGoToActivity.setOnClickListener {
//            goToActivity<MainActivity>()
            goToActivity<MainActivity>{
                putExtra("id", 1)
            }
        }
    }
}
