package com.aaqanddev.flickrbrowser

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FlickrImageViewHolder(view: View): RecyclerView.ViewHolder(view){
    var thumbnail = view.findViewById<ImageView>(R.id.thumbnail)
    var title = view.findViewById<TextView>(R.id.title)
}
class FlickrRecyclerViewAdapter(private var photoList: List<Photo>): RecyclerView.Adapter<FlickrImageViewHolder>() {
    private val TAG = "FlickrRVAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlickrImageViewHolder {
        //called by layoutManager when new view needed
        Log.d(TAG, ".onCreateViewHolder new view requested")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.browse, parent, false)
        return FlickrImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, ".getItemCount called")
        return if (photoList.isNotEmpty()) photoList.size else 0
    }

    fun loadNewData(newPhotos: List<Photo>){
        photoList = newPhotos
        notifyDataSetChanged()
    }

    fun getPhoto(pos: Int): Photo?{
        return if (photoList.isNotEmpty()) photoList[pos] else null
    }
    override fun onBindViewHolder(holder: FlickrImageViewHolder, position: Int) {
        //called by layoutmanager to populate data
        Log.d(TAG, ".onBindViewHolder called")
        val photoItem = photoList[position]
        Log.d(TAG, ".onBindViewHolder: ${photoItem.title} --> $position")
        Picasso.get().load(photoItem.image).error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(holder.thumbnail)
        holder.title.text = photoItem.title

    }
}
