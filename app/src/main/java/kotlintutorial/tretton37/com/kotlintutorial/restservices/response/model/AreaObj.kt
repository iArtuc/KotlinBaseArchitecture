package kotlintutorial.tretton37.com.kotlintutorial.restservices.response.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ilkinartuc on 2017-06-29.
 */
class AreaObj(@SerializedName("id") val id: Int,
              @SerializedName("parent_id") val parent_id: Int,
              @SerializedName("name") val name: String,
              @SerializedName("area_type") val area_type: String)





