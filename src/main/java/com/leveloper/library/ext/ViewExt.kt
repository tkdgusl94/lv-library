package com.leveloper.library.ext

import android.view.View
import android.view.animation.AlphaAnimation
import androidx.annotation.UiThread

fun View.isVisible(): Boolean = this.visibility == View.VISIBLE

fun View.isGone(): Boolean = this.visibility == View.GONE

fun View.isInvisible(): Boolean = this.visibility == View.INVISIBLE

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.GONE
}

/**
 * View visibility
 * @param visible
 */
fun View?.visibilityExt(visible: Boolean) {
    this?.visibility = if (visible) View.VISIBLE else View.GONE
}

/**
 * List<View> visibility
 * @param visible
 */
fun List<View?>.visibilityExt(visible: Boolean) {
    this.forEach {
        it?.visibilityExt(visible)
    }
}

/***
 * Hides or shows view with given predicate
 */
inline fun <T : View> T.showIf(predicate: (T) -> Boolean) {
    if (predicate(this)) {
        show()
    } else {
        hide()
    }
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
