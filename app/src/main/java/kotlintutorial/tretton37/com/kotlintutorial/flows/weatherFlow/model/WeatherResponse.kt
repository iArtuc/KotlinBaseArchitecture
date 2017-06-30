package kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherResponse(@SerializedName("query") @Expose var query: Query)


