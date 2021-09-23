package com.leveloper.library.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leveloper.library.DispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel(dispatcherProvider: DispatcherProvider) : ViewModel(),
    DispatcherProvider by dispatcherProvider {

    private val _isLoading by lazy { MutableLiveData(false) }
    val isLoading: LiveData<Boolean> by lazy { _isLoading }

    private val _toastEvent by lazy { MutableEventLiveData<String>() }
    val toastEvent by lazy { _toastEvent.asEventLiveData() }

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.postValue(isLoading)
    }

    fun showToast(message: String) {
        _toastEvent.event = message
    }
}

/**
 * Simplify Android ViewModels by using these Kotlin extensions
 * [DispatcherProvider.main]
 */
inline fun BaseViewModel.onMain(
    crossinline body: suspend CoroutineScope.() -> Unit
) = viewModelScope.launch(main) {
    body(this)
}

/**
 * Simplify Android ViewModels by using these Kotlin extensions
 * [DispatcherProvider.io]
 */
inline fun BaseViewModel.onIO(
    crossinline body: suspend CoroutineScope.() -> Unit
) = viewModelScope.launch(io) {
    body(this)
}

/**
 * Simplify Android ViewModels by using these Kotlin extensions
 * [DispatcherProvider.default]
 */
inline fun BaseViewModel.onDefault(
    crossinline body: suspend CoroutineScope.() -> Unit
) = viewModelScope.launch(default) {
    body(this)
}