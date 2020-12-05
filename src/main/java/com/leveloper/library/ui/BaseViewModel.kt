package com.leveloper.library.ui

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(application: Application) : AndroidViewModel(application) {

    private var navigator: WeakReference<N>? = null

    private val isLoading = ObservableField(false)

    fun showLoading() {
        this.isLoading.set(true)
    }

    fun hideLoading() {
        this.isLoading.set(false)
    }

    fun getIsLoading() = isLoading

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    fun getNavigator() = navigator?.get()
}
