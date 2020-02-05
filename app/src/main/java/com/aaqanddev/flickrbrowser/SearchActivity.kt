package com.aaqanddev.flickrbrowser

import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity() {
    private val TAG = "SearchActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, ".onCreate begins")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        activateToolbar(true)
        Log.d(TAG, ".onCreate ends")
    }

}
