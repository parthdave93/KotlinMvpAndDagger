package com.parthdave93.kotlindaggerdemo.di.network

import com.parthdave93.kotlindaggerdemo.core.ApplicationScope
import com.parthdave93.kotlindaggerdemo.ui.login.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 29-06-2018.
 */

@ApplicationScope
@Component(modules = [NetworkModule::class, PrefsModule::class, PresenterModule::class])
interface NetworkComponent {

    fun inject(context: MainActivity)

}