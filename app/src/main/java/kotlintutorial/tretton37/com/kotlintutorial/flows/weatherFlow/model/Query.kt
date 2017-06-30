package kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Query(
        @SerializedName("count")
        @Expose
        var count: Int,
        @SerializedName("created")
        @Expose
        var created: String,
        @SerializedName("lang")
        @Expose
        var lang: String,
        @SerializedName("results")
        @Expose
        var results: Results
)
