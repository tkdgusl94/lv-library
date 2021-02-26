package com.leveloper.library.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingActivity<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int)
    : AppCompatActivity(layoutResId) {

    protected lateinit var binding: B
        private set

    protected abstract fun prepareActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)

        prepareActivity()
    }
}