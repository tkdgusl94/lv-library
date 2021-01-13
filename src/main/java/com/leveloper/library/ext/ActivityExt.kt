package com.leveloper.library.ext

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Force close keyboard
 */
fun Activity.hideKeyboard() {
    currentFocus?.let {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, @IdRes frameId: Int, tag: String? = null) {
    supportFragmentManager.transact {
        replace(frameId, fragment, tag)
    }
}

fun AppCompatActivity.addFragment(fragment: Fragment, @IdRes frameId: Int, tag: String? = null) {
    supportFragmentManager.transact {
        add(frameId, fragment, tag)
    }
}