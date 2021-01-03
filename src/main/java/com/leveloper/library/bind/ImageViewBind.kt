package com.leveloper.library.bind

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter(value = ["loadUrl"])
fun ImageView.loadUrl(url: String?) {
    Glide.with(this)
        .load(url)
        .thumbnail(0.1f)
        .into(this)
}

@BindingAdapter(value = ["loadUrlCircle"])
fun ImageView.loadUrlCircle(url: String?) {
    Glide.with(this)
        .load(url)
        .thumbnail(0.1f)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

@BindingAdapter(value = ["drawableResId"])
fun ImageView.setDrawableResId(@DrawableRes resId: Int) {
    setImageResource(resId)
}