package com.leveloper.library.ext

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.TypedValue
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.DrawableRes
import kotlin.math.roundToInt

fun Context.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
}

fun Context.callPhone(phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
    startActivity(intent)
}

fun Context.showPlayStore() {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
    startActivity(intent)
}

fun Context.dpToPx(dp: Int): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).roundToInt()
}

fun Context.showToast(message: String, isLongToast: Boolean = false) {
    Toast.makeText(
        this,
        message,
        if (isLongToast) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    ).show()
}

fun Context.showToast(resourceId: Int, isLongToast: Boolean = false) {
    showToast(getString(resourceId), isLongToast)
}

/**
 * Get String by name
 */
fun Context.getString(name: String?): String {
    return try {
        val id = resources.getIdentifier(name, "string", packageName)
        resources.getString(id)
    } catch (e: Exception) { "" }
}

/**
 * Get DrawableRes by name
 */
@DrawableRes
fun Context.getDrawableRes(name: String?): Int {
    return try {
        resources.getIdentifier(name, "drawable", packageName)
    } catch (e: Exception) { 0 }
}