package com.example.almondcafe.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.almondcafe.R
import com.example.almondcafe.base.BaseFragment
import com.example.almondcafe.databinding.FragmentSummaryBinding
import com.example.almondcafe.viewmodel.MainActivityVM
import javax.inject.Inject

class Summary : BaseFragment<FragmentSummaryBinding>() {
    override fun getLayout(): Int {
        return R.layout.fragment_summary
    }

    override fun isDataBindingEnabled(): Boolean {
        return true
    }

    @Inject
    lateinit var mainActivityVM: MainActivityVM


    companion object {
        fun newInstance(): Summary {
            val fragment = Summary()
            return fragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
}

