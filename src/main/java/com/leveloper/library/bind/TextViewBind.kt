package com.leveloper.library.bind

import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["textColorResId"])
fun TextView.setTextColorResId(@ColorRes resId: Int) {
    setTextColor(ContextCompat.getColor(context, resId))
}