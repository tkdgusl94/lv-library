package com.leveloper.library.ui

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

open class BaseViewModel<N> : ViewModel() {

    private var navigator: WeakReference<N>? = null

    private val _isLoading = NonNullMutableLiveData(false)
    val isLoading: NonNullLiveData<Boolean> = _isLoading

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String> = _toast

    private val _toastRes = MutableLiveData<Int>()
    val toastRes: LiveData<Int> = _toastRes

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    fun getNavigator() = navigator?.get()

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.postValue(isLoading)
    }

    fun showToast(message: String) {
        _toast.postValue(message)
    }

    fun showToast(@StringRes messageRes: Int) {
        _toastRes.postValue(messageRes)
    }
}
