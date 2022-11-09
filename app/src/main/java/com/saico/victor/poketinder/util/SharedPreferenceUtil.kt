package com.saico.victor.poketinder.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.saico.victor.poketinder.data.model.User

class SharedPreferenceUtil {

    companion object {
        private const val SHARED_PREFERENCE_KEY = "SHARED_PREFERENCE_KEY"

        private lateinit var sharedPreferences: SharedPreferences

        private const val USER = "USER_KEY"
    }

    fun setSharedPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
    }

    fun saveUser(user: User) {
        val gson = Gson()

        val jsonUser = gson.toJson(user)

        Log.e("SharedPreferenceUtil", "jsonUser: $jsonUser")

        sharedPreferences
            .edit()
            .putString(USER, jsonUser)
            .apply()
    }

    fun getUser(): User? {
        val gson = Gson()

        var user: User? = null

        val jsonUser = sharedPreferences.getString(USER, "")

        user = gson.fromJson(jsonUser, User::class.java)

        return user
    }
}