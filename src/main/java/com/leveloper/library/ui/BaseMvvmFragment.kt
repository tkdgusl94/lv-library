package com.leveloper.library.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.leveloper.library.BR

abstract class BaseMvvmFragment<B : ViewDataBinding, V : BaseViewModel<*>>(@LayoutRes private val layoutResId: Int) : Fragment() {

    protected abstract fun getViewModel(): V

    protected lateinit var binding: B
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.lifecycleOwner = this
        binding.setVariable(BR.vm, getViewModel())
        binding.executePendingBindings()

        return binding.root
    }

    protected fun binding(action: B.() -> Unit) {
        binding.run(action)
    }
}