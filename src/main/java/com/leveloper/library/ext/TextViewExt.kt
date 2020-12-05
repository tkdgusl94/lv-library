package com.leveloper.library.ext

import android.graphics.Paint
import android.widget.TextView

/**
 * Under Line
 */
fun TextView.underLine() {
    paint.flags = paint.flags or Paint.UNDERLINE_TEXT_FLAG
    paint.isAntiAlias = true
}

/**
 * Delete Line
 */
fun TextView.deleteLine() {
    paint.flags = paint.flags or Paint.STRIKE_THRU_TEXT_FLAG
    paint.isAntiAlias = true
}