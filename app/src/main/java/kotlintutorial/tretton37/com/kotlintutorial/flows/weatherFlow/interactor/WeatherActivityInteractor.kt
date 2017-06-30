package kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.interactor

import kotlintutorial.tretton37.com.kotlintutorial.base.BaseInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.listener.WeatherResultListener

/**
 * Created by ilkinartuc on 2017-07-07 with awesomeness.
 */


interface WeatherActivityInteractor : BaseInteractor {

    fun getWeatherFromApi(cityName: String, weatherResultListener: WeatherResultListener)

}