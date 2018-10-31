package com.parthdave93.kotlindaggerdemo.data

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 02-07-2018.
 */
interface Consumer<T> {
    fun onValueChanged(value: T)
}