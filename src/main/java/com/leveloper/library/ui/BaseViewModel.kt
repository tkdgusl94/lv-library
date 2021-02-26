package com.leveloper.library.ui

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

open class BaseViewModel<N> : ViewModel() {

    private var navigator: WeakReference<N>? = null

    private val _isLoading = NonNullMutableLiveData(false)
    val isLoading: NonNullLiveData<Boolean> = _isLoading

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    fun getNavigator() = navigator?.get()

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.postValue(isLoading)
    }
}
