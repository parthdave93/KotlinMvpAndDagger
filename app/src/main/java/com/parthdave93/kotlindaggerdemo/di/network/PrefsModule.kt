package com.parthdave93.kotlindaggerdemo.di.network

import android.content.SharedPreferences
import android.util.Log
import com.parthdave93.kotlindaggerdemo.core.ApplicationScope
import com.parthdave93.kotlindaggerdemo.data.Prefs
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 02-07-2018.
 */
@Module
open class PrefsModule @Inject constructor(val prefs: SharedPreferences){
    @Provides
    @ApplicationScope
    fun providesPrefs(): Prefs {
        Log.d("initLogs","Prefs Provides called")
        return Prefs(prefs)
    }
}