package com.parthdave93.kotlindaggerdemo.data

import android.content.SharedPreferences
import com.google.gson.Gson
import com.parthdave93.kotlindaggerdemo.models.User

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 02-07-2018.
 */
class Prefs {

    var sharedPref: SharedPreferences
    var map: HashMap<String, Consumer<Any>>? = null
    var gson = Gson()

    companion object {
        val AUTH_TOKEN = "AUTH_TOKEN"
        val USER_DATA = "USER_DATA"
    }


    constructor(pref: SharedPreferences) {
        sharedPref = pref
    }

    fun getAuthToken(): String? {
        return getString(AUTH_TOKEN)
    }

    fun getAuthToken(observer: Consumer<Any>): String? {
        registerObserver(AUTH_TOKEN,observer)
        return getString(AUTH_TOKEN)
    }

    private fun registerObserver(key: String, observable: Consumer<Any>) {
        if (map == null) {
            map = HashMap()
        }
        map?.put(key, observable)
    }

    fun putAuthToken(authToken: String) {
        putString(AUTH_TOKEN, authToken)
        awakeObservers(AUTH_TOKEN,authToken)
    }

    private fun awakeObservers(key: String, newValue: Any) {
        map?.get(key)?.onValueChanged(newValue)
    }

    fun getUser(): User? {
        var userData: String? = getString(USER_DATA)

        if (userData == null)
            return null

        return gson.fromJson(userData, User::class.java)
    }

    fun putUser(user: User) {
        putString(USER_DATA, gson.toJson(user))
    }


    private fun getString(key: String): String? {
        return sharedPref.getString(key, null)
    }

    private fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }

    private fun getLong(key: String): Long {
        return sharedPref.getLong(key, 0)
    }

    private fun getInt(key: String, value: Int): Int {
        return sharedPref.getInt(key, 0)
    }

    private fun getFloat(key: String, value: Float): Float {
        return sharedPref.getFloat(key, 0f)
    }

    private fun putString(key: String, value: String) {
        sharedPref.edit().putString(key, value).commit()
    }

    private fun putBoolean(key: String, value: Boolean) {
        sharedPref.edit().putBoolean(key, value).commit()
    }

    private fun putLong(key: String, value: Long) {
        sharedPref.edit().putLong(key, value).commit()
    }

    private fun putInt(key: String, value: Int) {
        sharedPref.edit().putInt(key, value).commit()
    }

    private fun putFloat(key: String, value: Float) {
        sharedPref.edit().putFloat(key, value).commit()
    }
}