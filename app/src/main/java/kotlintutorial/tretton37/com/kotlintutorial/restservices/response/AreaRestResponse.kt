package kotlintutorial.tretton37.com.kotlintutorial.restservices.response

import com.google.gson.annotations.SerializedName
import kotlintutorial.tretton37.com.kotlintutorial.restservices.response.model.AreaObj
import java.util.*

/**
 * Created by ilkinartuc on 2017-06-29.
 */


class AreaRestResponse(@SerializedName("isSuccess") val isSuccess: Boolean,
                       @SerializedName("area") val area: AreaObj,
                       @SerializedName("sub_areas") val subAreas: ArrayList<AreaObj>)