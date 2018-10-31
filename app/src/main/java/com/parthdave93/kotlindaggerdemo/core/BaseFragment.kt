package com.parthdave93.kotlindaggerdemo.core

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.parthdave93.kotlindaggerdemo.di.network.NetworkComponent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 03-07-2018.
 */
abstract class BaseFragment: Fragment(){
    var disposables : CompositeDisposable? = null

    fun addDisposable(disposable: Disposable){
        if(disposables==null)
            disposables = CompositeDisposable()
        disposables?.add(disposable)
    }

    override fun onStop() {
        disposables?.dispose()
        super.onStop()
    }

    fun dependentComponent() : NetworkComponent {
        return (activity?.application as ApplicationComponent).networkComponent!!
    }
}