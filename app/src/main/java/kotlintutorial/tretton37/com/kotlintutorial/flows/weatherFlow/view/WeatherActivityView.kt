package kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.view

import io.reactivex.Observable
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseView

/**
 * Created by ilkinartuc on 2017-07-07 with awesomeness.
 */
interface WeatherActivityView : BaseView {

    fun showWeatherInfo(info: String)


    fun showCityObservable(observable: Observable<Any>)

}