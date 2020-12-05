package com.leveloper.library.ext

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat

/**
 * Returns a compat drawable with tint added
 */
fun Drawable.withTint(@ColorInt colorInt: Int): Drawable {
    return with(this) {
        DrawableCompat.wrap(this).apply {
            DrawableCompat.setTint(this, colorInt)
        }
    }
}