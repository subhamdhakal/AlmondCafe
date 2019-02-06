package com.example.almondcafe.module

import com.example.almondcafe.repository.Repository
import com.example.almondcafe.viewmodel.MainActivityVM
import dagger.Module
import dagger.Provides
@Module
class MainActivityModule {
    @Provides
    fun providesMainActivityViewModel(repository: Repository): MainActivityVM {
        return MainActivityVM(repository)
    }
}