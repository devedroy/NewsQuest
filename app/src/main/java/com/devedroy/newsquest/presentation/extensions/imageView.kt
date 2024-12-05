package com.devedroy.newsquest.presentation.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.devedroy.newsquest.R

fun ImageView.loadImage(imageUrl: String) {
    Glide
        .with(this.context)
        .load(imageUrl)
        .centerCrop()
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this);
}