package com.parthdave93.kotlindaggerdemo.network.response

import com.google.gson.annotations.SerializedName
import com.parthdave93.kotlindaggerdemo.models.User

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 02-07-2018.
 */
open class LoginResponse : CommonResponse(){

    @SerializedName("data")
    var user: User? = null

}