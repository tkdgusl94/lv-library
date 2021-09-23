package com.leveloper.library.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BindingFragment<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : Fragment() {

    protected lateinit var binding: B
        private set

    protected abstract fun setBindings()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

        performDataBinding()

        return binding.root
    }

    private fun performDataBinding() {
        setBindings()

        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}