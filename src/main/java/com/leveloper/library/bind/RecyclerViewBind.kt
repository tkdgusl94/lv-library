package com.leveloper.library.bind

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leveloper.library.ui.helper.RecyclerViewDivider

@BindingAdapter(
    value = ["dividerHeight", "dividerPadding", "dividerColor"],
    requireAll = false
)
fun RecyclerView.setDivider(dividerHeight: Float?, dividerPadding: Float?, @ColorInt dividerColor: Int?) {
    addItemDecoration(
        RecyclerViewDivider(
            color = dividerColor ?: Color.TRANSPARENT,
            height = dividerHeight ?: 0f,
            padding = dividerPadding ?: 0f
        )
    )
}