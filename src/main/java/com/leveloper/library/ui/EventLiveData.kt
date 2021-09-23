package com.leveloper.library.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

typealias EventLiveData<T> = LiveData<Event<T>>

class MutableEventLiveData<T> : MutableLiveData<Event<T>>() {

    var event: T?
        get() = value?.peekContent()
        set(value) {
            if (value != null) {
                setValue(Event(value))
            }
        }

    fun postEvent(value: T?) {
        if (value != null) {
            postValue(Event(value))
        }
    }
}

fun <T> MutableEventLiveData<T>.asEventLiveData() = this as EventLiveData<T>

inline fun <T> EventLiveData<T>.observeEvent(owner: LifecycleOwner, crossinline observer: (T) -> Unit) {
    observe(owner, EventObserver { observer(it) })
}