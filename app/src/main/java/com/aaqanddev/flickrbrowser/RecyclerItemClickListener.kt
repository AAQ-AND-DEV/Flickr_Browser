package com.aaqanddev.flickrbrowser

import android.content.Context
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerItemClickListener(context: Context, recyclerView: RecyclerView,
                                private val listener: OnRecyclerClickListener): RecyclerView.SimpleOnItemTouchListener() {
    private val TAG = "recyclerItemClickListen"

    interface OnRecyclerClickListener{
        fun onItemClick(view: View, pos: Int)
        fun onItemLongClick(view: View, pos: Int)
    }

    //gestureDetector
    private val gestureDetector = GestureDetectorCompat(context, object : GestureDetector.SimpleOnGestureListener(){

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            Log.d(TAG, ".onSingleTapUp: starts")
            val childView = recyclerView.findChildViewUnder(e.x, e.y)
            Log.d(TAG, ".onSigleTapUp: calling listener.onItemClick")
            if (childView!=null){
                listener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView))
            }
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            Log.d(TAG, ".onLongPress: starts")
            val childView = recyclerView.findChildViewUnder(e.x, e.y)
            Log.d(TAG, ".onLongPress: calling listener.onItemLongClick")
            if (childView!=null){
                listener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView))
            }
        }
    })

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        Log.d(TAG, ".onInterceptTouchEvent: starts $e")
        val result = gestureDetector.onTouchEvent(e)
        Log.d(TAG, ".onInterceptTouchEvent() returning: $result")
        //return super.onInterceptTouchEvent(rv, e)
        //for intercepted touch event, return true

        return result
    }
}