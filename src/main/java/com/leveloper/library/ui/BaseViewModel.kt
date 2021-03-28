package com.leveloper.library.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

open class BaseViewModel : ViewModel() {

    private val _isLoading by lazy { NonNullMutableLiveData(false) }
    val isLoading: NonNullLiveData<Boolean> by lazy { _isLoading }

    private val _toast by lazy { MutableLiveData<Event<CharSequence>>() }
    val toast: LiveData<Event<CharSequence>> by lazy { _toast }

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.postValue(isLoading)
    }

    fun showToast(message: CharSequence) {
        _toast.value = Event(message)
    }
}
