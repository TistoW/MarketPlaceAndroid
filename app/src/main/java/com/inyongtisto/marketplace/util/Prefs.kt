package com.inyongtisto.marketplace.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class Prefs(activity: Activity) {

    private var sp: SharedPreferences? = null
    private val login = "login"

    init {
        sp = activity.getSharedPreferences("MYPREF", Context.MODE_PRIVATE)
    }


    fun setIsLogin(value: Boolean) {
        sp!!.edit().putBoolean(login, value).apply()
    }

    fun getIsLogin(): Boolean {
        return sp!!.getBoolean(login, false)
    }
}