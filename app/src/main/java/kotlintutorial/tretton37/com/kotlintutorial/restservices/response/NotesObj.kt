package kotlintutorial.tretton37.com.kotlintutorial.restservices.response

import com.google.gson.annotations.SerializedName

/**
 * Created by ilkinartuc on 2017-07-07 with awesomeness.
 */


data class NotesObj(@SerializedName("Notes") val notes: String)

