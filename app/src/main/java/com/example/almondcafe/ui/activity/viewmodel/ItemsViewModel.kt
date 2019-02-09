package com.example.almondcafe.ui.activity.viewmodel

import com.example.almondcafe.database.model.Item

class ItemsViewModel {
    var item: Item? = null
    fun getId(): String {
        return item!!.id.toString()+"."
    }

    fun getName(): String {
        return item!!.name
    }

    fun getPrice(): String {
        return "Rs "+item!!.price.toString()
    }

    fun getQuantity(): String {
        return item!!.quantity.toString()+" pcs"
    }

    fun getCategory(): String {
//        return "Category: "+item!!.category.toString()
        return "Cosmetics"
    }
}