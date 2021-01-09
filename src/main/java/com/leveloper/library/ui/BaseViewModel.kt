package com.leveloper.library.ui

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.lang.ref.WeakReference

open class BaseViewModel<N>(application: Application) : AndroidViewModel(application) {

    private var navigator: WeakReference<N>? = null

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String> = _toast

    private val _toastRes = MutableLiveData<Int>()
    val toastRes: LiveData<Int> = _toastRes

    init {
        _isLoading.value = false
    }

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
