package com.example.almondcafe.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.Preference
import javax.inject.Inject

class AppPreferences @Inject constructor(context: Context){
    private var preferences:SharedPreferences=context.getSharedPreferences(
        "almond_preferences",Context.MODE_PRIVATE
    )
    var isDataInserted: Boolean
        get() = preferences.getBoolean(com.example.almondcafe.constants.Preference.isDataInserted, false)
        set(data) = preferences.edit().putBoolean(com.example.almondcafe.constants.Preference.isDataInserted, data).apply()

}