package com.leveloper.library.ext

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
inline fun EditText.afterTextChanged(crossinline afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}

/**
 * Value
 */
var EditText.value: String
    get() = text.toString()
    set(value) = setText(value)

/**
 * Clears EditText
 */
fun EditText.clear() {
    setText("")
}