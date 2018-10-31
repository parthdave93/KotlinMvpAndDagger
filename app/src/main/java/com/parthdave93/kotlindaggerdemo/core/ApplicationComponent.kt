package com.parthdave93.kotlindaggerdemo.core

import android.app.Application
import android.content.Context
import com.parthdave93.kotlindaggerdemo.di.network.DaggerNetworkComponent
import com.parthdave93.kotlindaggerdemo.di.network.NetworkComponent
import com.parthdave93.kotlindaggerdemo.di.network.NetworkModule
import com.parthdave93.kotlindaggerdemo.di.network.PrefsModule

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 03-07-2018.
 */
class ApplicationComponent : Application() {

    var networkComponent: NetworkComponent? = null
    var preferenceName = "My_PREF"

    override fun onCreate() {
        super.onCreate()
        preferenceName = packageName + ".pref"
        networkComponent = DaggerNetworkComponent.builder()
                .networkModule(NetworkModule(this))
                .prefsModule(PrefsModule(getSharedPreferences(preferenceName, Context.MODE_PRIVATE)))
                .build();
    }


}