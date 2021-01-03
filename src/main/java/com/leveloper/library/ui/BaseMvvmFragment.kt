package com.leveloper.library.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.leveloper.library.BR

abstract class BaseMvvmFragment<T : ViewDataBinding, V : BaseViewModel<*>>(@LayoutRes layoutResId: Int)
    : BaseBindingFragment<T>(layoutResId) {

    protected abstract fun getViewModel(): V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        binding.setVariable(BR.vm, getViewModel())
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        return view
    }

    protected fun binding(action: T.() -> Unit) {
        binding.run(action)
    }
}