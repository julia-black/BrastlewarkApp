package com.juliablack.brastlewarkapp.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.juliablack.brastlewarkapp.R


fun View.visible(isVisible: Boolean = true) {
    this.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun ImageView.displayImage(context: Context, url: String, width: Int, height: Int) {
    val requestOptions = RequestOptions()
        .placeholder(R.drawable.ic_placeholder)
        .error(R.drawable.ic_placeholder)

    val requestBuilder = Glide.with(context)
        .asDrawable()
        .sizeMultiplier(0.1f)

    Glide.with(context)
        .applyDefaultRequestOptions(requestOptions)
        .load(url)
        .centerCrop()
        .override(width, height)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .thumbnail(requestBuilder)
        .into(this)
}