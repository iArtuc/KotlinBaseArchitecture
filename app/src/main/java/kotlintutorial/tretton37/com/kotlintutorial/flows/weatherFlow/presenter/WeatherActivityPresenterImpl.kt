package kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.presenter

import io.reactivex.Observable
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.WeatherActivity
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.interactor.WeatherActivityInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.listener.WeatherResultListener
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.view.WeatherActivityView
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.RxBus
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.events.testEvent
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-07-07 with awesomeness.
 */
class WeatherActivityPresenterImpl @Inject constructor(val weatherActivityInteractor:
                                                       WeatherActivityInteractor, val rxBus: RxBus) :
        WeatherActivityPresenter {
    override fun start(view: WeatherActivityView) {
        this.view = view
    }

    override fun getWeatherInCity(cityName: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        weatherActivityInteractor.getWeatherFromApi(cityName, object : WeatherResultListener {
            override fun onSuccess(string: String) {
                view.showCityObservable(Observable.just(string))
                rxBus.send(testEvent())
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(message: String) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })


    }

    override fun subscribe() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    lateinit var view: WeatherActivityView

    lateinit var activity: WeatherActivity


}