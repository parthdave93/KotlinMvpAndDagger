package com.parthdave93.kotlindaggerdemo.network

import com.parthdave93.kotlindaggerdemo.network.response.CommonResponse
import com.parthdave93.kotlindaggerdemo.network.response.LoginResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 03-07-2018.
 */
class NetworkRepository @Inject constructor(val webApi: WebApi) {

    fun login(mobileNo: String, otp: String, onSuccess: Consumer<LoginResponse>, onError: Consumer<Throwable>) : Disposable {
        return webApi.login(mobileNo, otp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onSuccess, onError)
    }

}