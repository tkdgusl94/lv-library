package com.leveloper.library.ext

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

fun <T> MediatorLiveData<T>.addSourceList(vararg sources: MutableLiveData<*>, onChanged: () -> T) {
    sources.forEach {
        this.addSource(it) { value = onChanged() }
    }
}