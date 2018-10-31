package com.parthdave93.kotlindaggerdemo.network

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 03-07-2018.
 */
interface NetworkResponder<T>{
    fun onSuccess(response: T)
    fun onError(response: T)
}