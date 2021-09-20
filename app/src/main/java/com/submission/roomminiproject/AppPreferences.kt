package com.submission.roomminiproject

import android.content.Context
import android.preference.PreferenceManager

class AppPreferences(context: Context) {
    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getTitle(): String = sharedPreferences.getString("get_Title", "")?: ""
}