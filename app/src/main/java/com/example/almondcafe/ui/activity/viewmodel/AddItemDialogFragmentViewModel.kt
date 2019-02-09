package com.example.almondcafe.ui.activity.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import com.example.almondcafe.database.model.Item

class AddItemDialogFragmentViewModel : BaseObservable() {
    var item: Item? = null
    var name: String = ""
    var quantity: String = ""
    var price: String = ""
    var buttonTextLabel:String="Add"
    var visibility:Int=View.GONE

    fun setData(item: Item) {
        this.name = item.name
        this.price = item.price.toString()
        this.quantity = item.quantity.toString()
        buttonTextLabel="Update"
        visibility=View.VISIBLE
        notifyChange()
    }

    @Bindable
    fun getItemName(): String {
        return name
    }

    @Bindable
    fun getItemPrice(): String {
        return price
    }

    @Bindable
    fun getItemQuantity(): String {
        return quantity
    }

    @Bindable
    fun getButtonText(): String {
       return buttonTextLabel
    }
    @Bindable
    fun getDeleteIconVisibility():Int{
      return visibility
    }
}