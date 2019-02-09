package com.example.almondcafe.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.almondcafe.R
import com.example.almondcafe.adapter.ItemsAdapter
import com.example.almondcafe.base.BaseFragment
import com.example.almondcafe.database.model.Item
import com.example.almondcafe.databinding.FragmentEditItemsBinding
import com.example.almondcafe.viewmodel.MainActivityVM
import com.yipl.labelstep.ui.dialogfragment.AddItemDialogFragment
import kotlinx.android.synthetic.main.fragment_edit_items.*
import javax.inject.Inject

class EditItems : BaseFragment<FragmentEditItemsBinding>(), SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(p0: String?): Boolean {
        searchItem(p0)
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        searchItem(p0)
        return true
    }

    lateinit var adapter: ItemsAdapter
    override fun getLayout(): Int {
        return R.layout.fragment_edit_items
    }

    override fun isDataBindingEnabled(): Boolean {
        return true
    }

    private fun searchItem(query: String?) {
        query?.let { mainActivityVM.setQuery(it) }
    }

    @Inject
    lateinit var mainActivityVM: MainActivityVM

    companion object {
        fun newInstance(): EditItems {
            val fragment = EditItems()
            return fragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_add_items.setOnClickListener {
            val correctiveActionsDialogFragment = AddItemDialogFragment.getInstance(null)
            correctiveActionsDialogFragment.setStyle(
                DialogFragment.STYLE_NORMAL,
                R.style.DialogFragmentTheme
            )
            correctiveActionsDialogFragment.show(fragmentManager, "hello")
        }
        search_view_item.queryHint="Search"
        search_view_item.setOnQueryTextListener(this)
        searchItem("")

        adapter = ItemsAdapter(context!!,object :ItemsAdapter.ClickListner{
            override fun onEditClickListner(item: Item) {
                Toast.makeText(context,"Name: "+item.name,Toast.LENGTH_SHORT).show()
                val correctiveActionsDialogFragment = AddItemDialogFragment.getInstance(item)
                correctiveActionsDialogFragment.setStyle(
                    DialogFragment.STYLE_NORMAL,
                    R.style.DialogFragmentTheme
                )
                correctiveActionsDialogFragment.show(fragmentManager, "hello")


            }
        }

        )
        mainActivityVM.getAllItem().observe(this, Observer {
            adapter.setData(it)
        })
        recycler_view_items.adapter = adapter
        recycler_view_items.layoutManager = LinearLayoutManager(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
}

