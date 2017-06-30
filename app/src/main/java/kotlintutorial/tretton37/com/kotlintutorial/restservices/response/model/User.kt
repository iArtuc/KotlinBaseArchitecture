package kotlintutorial.tretton37.com.kotlintutorial.restservices.response.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ilkinartuc on 2017-07-03.
 */
data class User(@SerializedName("name") var name: String){

    fun test(): String {
        return "osman $name"
    }
}