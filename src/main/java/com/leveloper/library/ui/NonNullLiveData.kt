package com.leveloper.library.ui

import androidx.databinding.InverseMethod
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

open class NonNullLiveData<T : Any>(value: T) : LiveData<T>(value) {

    override fun getValue(): T {
        return super.getValue() as T
    }

    inline fun observe(owner: LifecycleOwner, crossinline observer: (t: T) -> Unit) {
        this.observe(owner, Observer {
            it?.let(observer)
        })
    }
}

class NonNullMutableLiveData<T : Any>(value: T) : NonNullLiveData<T>(value) {
    public override fun setValue(value: T) {
        super.setValue(value)
    }

    public override fun postValue(value: T) {
        super.postValue(value)
    }
}