package com.leveloper.library.ui

import android.os.Bundle
import com.leveloper.library.BR
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.leveloper.library.ext.observe
import com.leveloper.library.ext.showToast

abstract class BaseMvvmActivity<B : ViewDataBinding, V : BaseViewModel<*>>(@LayoutRes private val layoutResId: Int)
    : AppCompatActivity(layoutResId) {

    protected lateinit var binding: B
        private set

    protected abstract fun getViewModel(): V

    protected abstract fun prepareActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        binding.setVariable(BR.vm, getViewModel())
        binding.executePendingBindings()

        prepareActivity()
        subscribeToLiveData()
    }

    open fun subscribeToLiveData() {}

    protected fun binding(action: B.() -> Unit) {
        binding.run(action)
    }
}