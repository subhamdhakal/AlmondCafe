package com.example.almondcafe.viewmodel

import android.arch.lifecycle.*
import com.example.almondcafe.database.model.Item
import com.example.almondcafe.repository.Repository
import javax.inject.Inject
//
class MainActivityVM @Inject constructor (var repository: Repository){

    var query:MutableLiveData<String> = MutableLiveData()
    var itemsList :LiveData<List<Item>> = MediatorLiveData()

    fun insertItem(item: Item){
        repository.insertItem(item)
    }
    fun updateItem(item: Item){
        repository.updateItem(item)
    }
    fun getAllItem():LiveData<List<Item>>{
        return itemsList
    }

    fun setQuery(query: String) {
        this.query.value=query
    }

    fun insertAllData() {
        repository.insertAllData()

    }

    fun deleteItem(item: Item) {
        repository.deleteItem(item)
    }

    init {
        itemsList=Transformations.switchMap(query){
            repository.getAllItems(it?:"")
        }
    }

}