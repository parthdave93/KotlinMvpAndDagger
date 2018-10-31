package com.parthdave93.kotlindaggerdemo.network.presenters

import com.parthdave93.kotlindaggerdemo.data.Prefs
import com.parthdave93.kotlindaggerdemo.network.NetworkRepository
import com.parthdave93.kotlindaggerdemo.network.response.CommonResponse
import com.parthdave93.kotlindaggerdemo.network.response.LoginResponse
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 03-07-2018.
 */

class LoginPresenterImpl @Inject constructor(val networkApi: NetworkRepository,val prefs: Prefs) : LoginContract.LoginPresenter {

    override fun login(mobileNo: String?, otp: String?, loginResponder: LoginContract.LoginResponder): Disposable? {
        if (mobileNo == null) {
            loginResponder.invalidMobileNo()
            return null
        }
        /*if (!mobileNo.isValidMobileNo() ) {

        }*/
        if(otp == null || otp.isBlank()){
            loginResponder.invalidOtp()
            return null
        }

        return networkApi?.login(mobileNo!!, otp!!, Consumer<LoginResponse> {
            t: LoginResponse? ->
            t?.user?.authToken?.let {
                prefs.putAuthToken(it)
            }
            loginResponder.onLoginSuccess(t)
        }, Consumer<Throwable> {
            t: Throwable? ->
            t?.message?.let {
                loginResponder.showError(it)
            }
        })
    }
}