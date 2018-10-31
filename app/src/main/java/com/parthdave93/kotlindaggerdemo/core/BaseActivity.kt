package com.parthdave93.kotlindaggerdemo.core

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.parthdave93.kotlindaggerdemo.di.network.DaggerNetworkComponent
import com.parthdave93.kotlindaggerdemo.di.network.NetworkComponent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 29-06-2018.
 */

abstract class BaseActivity: AppCompatActivity() , BaseContext{

    var disposables : CompositeDisposable? = null

    override fun getContext():Context{
        return this@BaseActivity
    }

    fun addDisposable(disposable: Disposable){
        if(disposables==null)
            disposables = CompositeDisposable()
        disposables?.add(disposable)
    }

    override fun onStop() {
        disposables?.dispose()
        super.onStop()
    }

    fun dependentComponent() : NetworkComponent{
        return (application as ApplicationComponent).networkComponent!!
    }
}