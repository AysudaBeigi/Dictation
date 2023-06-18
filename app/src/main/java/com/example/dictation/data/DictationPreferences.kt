package com.example.dictation.data

import android.content.Context
import android.content.SharedPreferences


private const val IS_FIRST_TIME_USING = "isFirstTimeUsing"

private const val DICTATION_PREF_KEY = "dictationPrefKey"

class DictationPreferences(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(DICTATION_PREF_KEY, Context.MODE_PRIVATE)

    var isFirstTimeUsing: Boolean
        get() = preferences.getBoolean(IS_FIRST_TIME_USING, true)
        set(value) = preferences.edit().putBoolean(IS_FIRST_TIME_USING, false).apply()

}