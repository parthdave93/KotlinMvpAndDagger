package com.parthdave93.kotlindaggerdemo.di.network

import android.util.Log
import com.parthdave93.kotlindaggerdemo.data.Prefs
import com.parthdave93.kotlindaggerdemo.network.NetworkRepository
import com.parthdave93.kotlindaggerdemo.network.WebApi
import com.parthdave93.kotlindaggerdemo.network.presenters.LoginPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 03-07-2018.
 */
@Module
class PresenterModule {

    @Provides
    fun providesNetworkRepository(webApi: WebApi): NetworkRepository{
        Log.d("initLogs","providesNetworkRepository called")
        return NetworkRepository(webApi)
    }

    @Provides
    fun providesLoginPresenter(networkRepository: NetworkRepository,prefs: Prefs): LoginPresenterImpl{
        Log.d("initLogs","providesLoginPresenter called")
        return LoginPresenterImpl(networkRepository,prefs)
    }
}