package com.parthdave93.kotlindaggerdemo.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 02-07-2018.
 */

class User{
    @SerializedName("first_name")
    var first_name: String? = null
    @SerializedName("last_name")
    var last_name: String? = null
    @SerializedName("user_name")
    var user_name: String? = null
    @SerializedName("user_pic")
    var user_pic: String? = null
    @SerializedName("phone_number")
    var phone_number: String? =null
    @SerializedName("user_id")
    var user_id : String? = null
    @SerializedName("auth_token")
    var authToken : String? = null


}