package com.example.almondcafe.di


import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.almondcafe.database.AlmondCafeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context = application.applicationContext
////
////    @Provides
////    @Singleton
////    fun provideAppPreferences(application: Application): AppPreferences {
////        return AppPreferences(application)
////    }
////
////
////    @Provides
////    @Singleton
////    fun provideServiceProvider(appPreferences: AppPreferences): ApiServiceProvider {
////        return ApiServiceProvider(appPreferences)
////    }
//
//    @Provides
//    @Singleton
//    fun provideDatabase(application: Application): AlmondCafeDatabase {
//        val database: AlmondCafeDatabase = Room
//            .databaseBuilder(
//                application.applicationContext,
//                AlmondCafeDatabase::class.java, "almond_database"
//            )
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigration()
//            .build()
//        return database
//    }
//
//    @Provides
//    @Singleton
//    fun provideDayDao(database: AlmondCafeDatabase) = database.itemDao
//
//    @Provides
//    @Singleton
//    fun provideDayDao(database: DayDatabase) = database.toDoDao
}