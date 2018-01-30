package com.shellcore.android.kotlinapplication.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.shellcore.android.kotlinapplication.R
import com.shellcore.android.kotlinapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : ToolbarActivity() {

    private val REQUEST_CAMERA_PERMISSION = 100
    private val REQUEST_CAMERA_PICTURE = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

//        btnPicture.setOnClickListener { getPictureFromCameraAskingPermissions() }
        btnPicture.setOnClickListener { getPictureFromCamera() }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CAMERA_PERMISSION -> {
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, REQUEST_CAMERA_PICTURE)
                } else {
                    Toast.makeText(this, "You can't take a picture if you don't allow it!", Toast.LENGTH_SHORT)
                            .show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CAMERA_PICTURE -> {
                if (resultCode == Activity.RESULT_OK) {
                    val extras = data!!.extras
                    val imageBitmap = extras.get("data") as Bitmap
                    imgPicture.setImageBitmap(imageBitmap)
                } else {
                    Toast.makeText(this, "Picture has failed!", Toast.LENGTH_SHORT)
                            .show()
                }
            }
        }
    }

    private fun getPictureFromCameraAskingPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), REQUEST_CAMERA_PERMISSION)
        } else {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_CAMERA_PICTURE)
        }
    }

    private fun getPictureFromCamera() {
        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (pictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(pictureIntent, REQUEST_CAMERA_PICTURE)
        } else {
            Toast.makeText(this, "No hay cámara o app de cámara", Toast.LENGTH_SHORT)
                    .show()
        }
    }
}
