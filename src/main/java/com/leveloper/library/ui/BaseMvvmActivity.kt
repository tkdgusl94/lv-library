package com.leveloper.library.ui

import android.os.Bundle
import com.leveloper.library.BR
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.leveloper.library.ext.observe
import com.leveloper.library.ext.showToast

abstract class BaseMvvmActivity<T : ViewDataBinding, V : BaseViewModel<*>>(@LayoutRes layoutResId: Int)
    : BaseBindingActivity<T>(layoutResId) {

    private lateinit var vm: V

    protected abstract fun getViewModel(): V

    protected abstract fun prepareActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = getViewModel()

        performDataBinding()
        prepareActivity()
        subscribeToLiveData()
    }

    open fun subscribeToLiveData() {
        observe(vm.toast) {
            showToast(it)
        }

        observe(vm.toastRes) {
            showToast(it)
        }
    }

    private fun performDataBinding() {
        binding.lifecycleOwner = this
        binding.setVariable(BR.vm, vm)
        binding.executePendingBindings()
    }

    protected fun binding(action: T.() -> Unit) {
        binding.run(action)
    }
}