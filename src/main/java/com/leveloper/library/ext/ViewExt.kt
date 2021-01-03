package com.leveloper.library.ext

import android.view.View
import androidx.annotation.UiThread

fun View.isVisible(): Boolean = this.visibility == View.VISIBLE

fun View.isGone(): Boolean = this.visibility == View.GONE

fun View.isInvisible(): Boolean = this.visibility == View.INVISIBLE

fun View?.show() {
    this?.visibility = View.VISIBLE
}

fun View?.hide() {
    this?.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View?.showIf(visible: Boolean) {
    if (visible) show() else hide()
}

fun List<View?>.showIf(visible: Boolean) {
    this.forEach { it.showIf(visible) }
}

inline fun <T : View> T.showIf(predicate: (T) -> Boolean) {
    showIf(predicate(this))
}

inline fun <T: View> List<T>.showIf(predicate: (T) -> Boolean) {
    this.forEach { it.showIf(predicate(it)) }
}

@UiThread
fun View.fadeIn(duration: Long = 500L) {
    animate().alpha(1.0f).duration = duration
}

@UiThread
fun View.fadeOut(duration: Long = 500L) {
    animate().alpha(0.0f).duration = duration
}

inline fun <reified T: View> T.click(crossinline block: (T) -> Unit) = setOnClickListener { block(it as T) }

inline fun <reified T: View> T.longClick(crossinline block: (T) -> Boolean) = setOnLongClickListener { block(it as T) }