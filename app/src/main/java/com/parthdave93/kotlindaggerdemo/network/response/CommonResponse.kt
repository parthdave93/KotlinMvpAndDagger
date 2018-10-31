package com.parthdave93.kotlindaggerdemo.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 02-07-2018.
 */

open class CommonResponse{
    @SerializedName("status")
    var status: Int = 0
    @SerializedName("message")
    var message : String? = null
    @SerializedName("error")
    var error : String? = null
}