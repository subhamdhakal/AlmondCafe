package com.example.almondcafe.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.almondcafe.R
import com.example.almondcafe.database.model.Item
import com.example.almondcafe.databinding.ItemItemsBinding
import com.example.almondcafe.ui.activity.viewmodel.ItemsViewModel

class ItemsAdapter(var context: Context,var listener:ClickListner) : RecyclerView.Adapter<ItemsAdapter.ItemAdapterViewHolder>() {
    var listOfItems: List<Item> = ArrayList()

    interface ClickListner{
        fun onEditClickListner(item: Item)
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemAdapterViewHolder {
        val binding: ItemItemsBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_items, p0, false)
        return ItemAdapterViewHolder(binding)
    }

    fun setData(data: List<Item>?) {
        this.listOfItems = data!!
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    override fun onBindViewHolder(p0: ItemAdapterViewHolder, p1: Int) {
        return p0.bind(listOfItems[p1])
    }
    inner class ItemAdapterViewHolder(var binding: ItemItemsBinding) : RecyclerView.ViewHolder(binding.root),View.OnClickListener{
       var itemViewModel=ItemsViewModel()
        override fun onClick(v: View?) {
            if(v?.id==binding.textViewEditItems.id)
                return listener.onEditClickListner(itemsViewModel.item!!)
        }
        init {
            binding.textViewEditItems.setOnClickListener(this)
            binding.viewModel=itemViewModel
        }

        var itemsViewModel:ItemsViewModel= ItemsViewModel()
        fun bind(item: Item) {
            itemsViewModel.item=item
            binding.viewModel=itemsViewModel

        }
    }
}