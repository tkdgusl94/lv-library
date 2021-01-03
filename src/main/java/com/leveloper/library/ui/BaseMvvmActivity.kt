package com.leveloper.library.ui

import android.os.Bundle
import com.leveloper.library.BR
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class BaseMvvmActivity<T : ViewDataBinding, V : BaseViewModel<*>>(@LayoutRes layoutResId: Int)
    : BaseBindingActivity<T>(layoutResId) {

    protected abstract fun getViewModel(): V

    abstract fun prepareActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDataBinding()
        prepareActivity()
    }

    private fun performDataBinding() {
        binding.lifecycleOwner = this
        binding.setVariable(BR.vm, getViewModel())
        binding.executePendingBindings()
    }

    protected fun binding(action: T.() -> Unit) {
        binding.run(action)
    }
}