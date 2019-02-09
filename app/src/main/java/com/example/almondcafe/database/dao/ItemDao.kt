package com.example.almondcafe.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.almondcafe.database.model.Item

@Dao
interface ItemDao {
    @Insert
    fun insertItem(item: Item)

    @Query("SELECT * FROM item_table")
    fun getAllItems(): LiveData<List<Item>>

    @Query("Select * from item_table where name like '%' || :name || '%'")
    fun getItems(name: String): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllItems(items: List<Item>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}