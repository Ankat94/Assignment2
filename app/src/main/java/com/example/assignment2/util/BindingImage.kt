package com.example.assignment2.util

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("image")
fun setImageUrl(imageView: ImageView, url: String?) {
    Picasso.get().load(url).into(imageView)
}
