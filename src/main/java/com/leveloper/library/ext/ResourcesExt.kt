package com.leveloper.library.ext

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import kotlin.math.roundToInt

val Resources.statusBarHeight: Int
    get() {
        val resourceId = getIdentifier("status_bar_height", "dimen", "android")

        return if (resourceId > 0) getDimensionPixelSize(resourceId) else 0
    }

fun Resources.dpToPx(dp: Int): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), displayMetrics).roundToInt()
}