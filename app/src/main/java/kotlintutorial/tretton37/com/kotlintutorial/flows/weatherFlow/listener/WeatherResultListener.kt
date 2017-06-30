package kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.listener

import kotlintutorial.tretton37.com.kotlintutorial.mvp.listener.BaseListener

/**
 * Created by ilkinartuc on 2017-07-11 with awesomeness.
 */
interface WeatherResultListener : BaseListener {
    fun onSuccess(string: String)

}