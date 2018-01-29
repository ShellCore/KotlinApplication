package com.shellcore.android.kotlinapplication.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shellcore.android.kotlinapplication.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*

class PicassoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        btnLoader.setOnClickListener {
            loadImages()
        }

        Picasso.with(this)
                .load("http://freakelitex.com/wp-content/uploads/2016/04/ffxv.jpg")
                .fetch()
    }

    private fun loadImages() {
        Picasso.with(this)
                .load("http://freakelitex.com/wp-content/uploads/2016/04/ffxv.jpg")
                .resize(400, 400)
                .centerInside()
                .into(imgTop)

//        Picasso.with(this)
//                .load("https://vignette.wikia.nocookie.net/finalfantasy/images/9/9a/Bahamut_Emerges.png")
//                .fit()
//                .into(imgBottom)

//        Picasso.with(this)
//                .load("https://vignette.wikia.nocookie.net/finalfantasy/images/9/9a/Bahamut_Emerges.png")
//                .fit()
//                .transform(CircleTransform())
//                .into(imgBottom)

        val context: Context = this

        Picasso.with(context)
                .load("https://vignette.wikia.nocookie.net/finalfantasy/images/9/9a/Bahamut_Emerges.png")
                .fetch(object: Callback {
                    override fun onSuccess() {
                        imgBottom.alpha = 0f
                        Picasso.with(context)
                                .load("https://vignette.wikia.nocookie.net/finalfantasy/images/9/9a/Bahamut_Emerges.png")
                                .fit()
                                .into(imgBottom)

                        imgBottom.animate()
                                .setDuration(3000)
                                .alpha(1f)
                                .start()
                    }

                    override fun onError() {

                    }

                })
    }
}
