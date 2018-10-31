package com.parthdave93.kotlindaggerdemo.network.presenters

import com.parthdave93.kotlindaggerdemo.network.response.CommonResponse
import com.parthdave93.kotlindaggerdemo.network.response.LoginResponse
import io.reactivex.disposables.Disposable

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 03-07-2018.
 */
interface LoginContract{
    interface LoginPresenter{
        fun login(mobileNo: String?, otp: String?, loginResponder: LoginContract.LoginResponder) : Disposable?
    }

    interface LoginResponder{
        fun onLoginSuccess(loginResponse: LoginResponse?)
        fun onOtpSuccess(commonResponse: CommonResponse?)
        fun showError(message : String)
        fun invalidOtp()
        fun invalidMobileNo()
    }
}