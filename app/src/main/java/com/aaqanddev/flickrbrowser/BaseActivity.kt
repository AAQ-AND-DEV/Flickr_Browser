package com.aaqanddev.flickrbrowser

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

    internal const val FLICKR_QUERY = "Flickr_Query"
    internal const val PHOTO_TRANSFER = "Photo_Transfer"

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(){
    private val TAG = "BaseActivity"

    internal fun activateToolbar(enableHome:Boolean){
        Log.d(TAG, ".activateToolbar")

        var toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(enableHome)

    }
}