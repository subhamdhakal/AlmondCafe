package com.example.almondcafe.di

import com.example.almondcafe.activity.MainActivity
import com.example.almondcafe.module.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder{

//    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
//    abstract fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity():MainActivity
}