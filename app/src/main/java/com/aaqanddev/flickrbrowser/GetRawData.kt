package com.aaqanddev.flickrbrowser

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.lang.Exception
import java.net.MalformedURLException
import java.net.URL

enum class DownloadStatus{
    OK, IDLE, NOT_INITIALIZED, FAILED_OR_EMPTY, PERMISSIONS_ERROR,ERROR
}
class GetRawData : AsyncTask<String, Void, String>() {
    private val TAG = "GetRawData"
    private var downloadStatus = DownloadStatus.IDLE

    override fun onPostExecute(result: String?) {
        Log.d(TAG, "OnpostExectute valled, paramter is $result")
    }

    override fun doInBackground(vararg params: String?): String {
        if (params[0] == null){
            downloadStatus = DownloadStatus.NOT_INITIALIZED
            return "no URL specified"
        }
        try {
            downloadStatus = DownloadStatus.OK
            return URL(params[0]).readText()
        } catch(e: Exception){
            val errorMessage = when (e){
                is MalformedURLException -> {
                    downloadStatus = DownloadStatus.NOT_INITIALIZED
                    "doInBackground: Invalid URL ${e.message}"
                }
                is IOException -> {
                    downloadStatus = DownloadStatus.FAILED_OR_EMPTY
                    "doinBackground: IO Exception reading data ${e.message}"
                }
                is SecurityException ->{
                    downloadStatus = DownloadStatus.PERMISSIONS_ERROR
                    "doinBackground: security exception: needs permission? ${e.message}"
                }
                else -> {
                    downloadStatus = DownloadStatus.ERROR
                    "unknown error: ${e.message}"
                }
        }
        Log.e(TAG, errorMessage)
        return errorMessage
        }
    }
}