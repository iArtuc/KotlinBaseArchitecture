package kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.presenter

import kotlintutorial.tretton37.com.kotlintutorial.base.BasePresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.view.WeatherActivityView

/**
 * Created by ilkinartuc on 2017-07-07 with awesomeness.
 */


interface WeatherActivityPresenter : BasePresenter<WeatherActivityView> {

    fun getWeatherInCity(cityName: String)

}