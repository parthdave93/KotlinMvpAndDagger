package com.parthdave93.kotlindaggerdemo.ui.login

import android.os.Bundle
import android.util.Log
import com.parthdave93.kotlindaggerdemo.R
import com.parthdave93.kotlindaggerdemo.core.BaseActivity
import com.parthdave93.kotlindaggerdemo.data.Consumer
import com.parthdave93.kotlindaggerdemo.data.Prefs
import com.parthdave93.kotlindaggerdemo.network.presenters.LoginContract
import com.parthdave93.kotlindaggerdemo.network.presenters.LoginPresenterImpl
import com.parthdave93.kotlindaggerdemo.network.response.CommonResponse
import com.parthdave93.kotlindaggerdemo.network.response.LoginResponse
import javax.inject.Inject


class MainActivity : BaseActivity() , LoginContract.LoginResponder {

    @Inject lateinit var prefs: Prefs
    @Inject lateinit var loginPresenter: LoginPresenterImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dependentComponent().inject(this)

        val consumer = object : Consumer<String> {
            override fun onValueChanged(value: String) {
                Log.d("token",value)
            }
        } as Consumer<Any>
        prefs.getAuthToken(consumer)
        prefs.putAuthToken("asd")

        loginPresenter.login("123","123",this)?.let {
            addDisposable(it)
        }
    }

    override fun onLoginSuccess(loginResponse: LoginResponse?) {

    }

    override fun onOtpSuccess(commonResponse: CommonResponse?) {

    }

    override fun showError(message: String) {

    }

    override fun invalidOtp() {

    }

    override fun invalidMobileNo() {

    }
}
