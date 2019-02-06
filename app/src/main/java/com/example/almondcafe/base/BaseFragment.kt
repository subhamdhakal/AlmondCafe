package com.example.almondcafe.base
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

public abstract class BaseFragment<T : ViewDataBinding> : DaggerFragment() {
    abstract fun getLayout(): Int
    protected lateinit var binding: T
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View
        if (isDataBindingEnabled()) {
            binding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
            view = binding.root
        } else {
            view = inflater.inflate(getLayout(), container, false)
        }
        setHasOptionsMenu(true)
        return view
    }

    open fun isDataBindingEnabled(): Boolean {
        return false
    }
}