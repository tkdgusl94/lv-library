package com.leveloper.library.bind

import android.view.View
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion

@BindingConversion
fun convertBooleanToVisibility(visible: Boolean) = if (visible) View.VISIBLE else View.GONE

@BindingAdapter(value = ["backgroundResId"])
fun View.setBackgroundResId(@DrawableRes resId: Int) {
    setBackgroundResource(resId)
}
