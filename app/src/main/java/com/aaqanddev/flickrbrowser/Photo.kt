package com.aaqanddev.flickrbrowser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Photo(var title: String, var author: String,
            var authorId:String, var link: String,
            var tags: String, var image: String) : Parcelable {

    override fun toString(): String {
        return "Photo(title='$title', author='$author', authorId='$authorId', link='$link', tags='$tags', image='$image')"
    }



}