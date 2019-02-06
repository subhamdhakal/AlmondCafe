package com.example.almondcafe.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.almondcafe.database.dao.ItemDao
import com.example.almondcafe.database.model.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class AlmondCafeDatabase : RoomDatabase() {
    abstract val itemDao:ItemDao

}
