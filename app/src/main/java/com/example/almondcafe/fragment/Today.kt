package com.example.almondcafe.fragment

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.almondcafe.R
import com.example.almondcafe.base.BaseFragment
import com.example.almondcafe.databinding.FragmentTodayBinding
import com.example.almondcafe.viewmodel.MainActivityVM
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Today : Fragment(){

    @Inject
    lateinit var mainActivityVM:MainActivityVM


//    override fun getLayout(): Int {
//        return R.layout.fragment_today
//    }
//
//    override fun isDataBindingEnabled(): Boolean {
//        super.isDataBindingEnabled()
//        return true
//    }

    companion object {
        fun newInstance(): Today {
            val fragment = Today()
            return fragment
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}
