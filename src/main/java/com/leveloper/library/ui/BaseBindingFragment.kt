package com.leveloper.library.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseBindingFragment<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : Fragment() {

    protected lateinit var binding: B
        private set

    private var activity: BaseBindingActivity<*>? = null

    protected abstract fun prepareFragment()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseBindingActivity<*>) {
            activity = context
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareFragment()
    }

    override fun onDetach() {
        if (context is BaseBindingActivity<*>) {
            activity?.onFragmentDetached()
            activity = null
        }
        super.onDetach()
    }

    fun getBaseActivity() = activity

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached()
    }
}