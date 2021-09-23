package com.leveloper.library.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingActivity<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : AppCompatActivity(layoutResId) {

    protected val binding: B by lazy { DataBindingUtil.setContentView(this, layoutResId) }

    protected abstract fun setBindings()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDataBinding()
    }

    private fun performDataBinding() {
        setBindings()

        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}