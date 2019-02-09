package com.example.almondcafe.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var price: Int?,
    var quantity: Int
)