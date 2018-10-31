package com.parthdave93.kotlindaggerdemo.network

import com.parthdave93.kotlindaggerdemo.network.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 29-06-2018.
 */

interface WebApi {

    companion object {
        const val BASE_URL = "http://www.google.com/"
        const val LOGIN_URL = "login"
    }

    @FormUrlEncoded
    @POST(LOGIN_URL)
    fun login(@Field("username") userName: String,@Field("password") password: String) : Observable<LoginResponse>

}