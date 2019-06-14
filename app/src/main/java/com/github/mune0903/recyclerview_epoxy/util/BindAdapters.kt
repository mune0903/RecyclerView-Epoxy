package com.github.mune0903.recyclerview_epoxy.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:image")
fun loadImage(v: ImageView, url: String?) {
    Glide
        .with(v.context)
        .load(url)
        .centerCrop()
        .into(v)
}