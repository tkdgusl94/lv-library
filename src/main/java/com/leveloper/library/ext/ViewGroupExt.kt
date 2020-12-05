package com.leveloper.library.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes l: Int): View =
    LayoutInflater.from(context).inflate(l, this, false)

fun ViewGroup.contains(child: View) = indexOfChild(child) != -1