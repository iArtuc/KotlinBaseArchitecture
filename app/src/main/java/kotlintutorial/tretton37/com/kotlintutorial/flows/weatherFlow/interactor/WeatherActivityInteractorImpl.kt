package kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.interactor

import android.util.Log
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.listener.WeatherResultListener
import kotlintutorial.tretton37.com.kotlintutorial.restservices.RestService
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.SchedulerProvider
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-07-07 with awesomeness.
 */


class WeatherActivityInteractorImpl @Inject constructor(val restService: RestService,
                                                        val schedulerProvider: SchedulerProvider) :
        WeatherActivityInteractor {
    override fun getWeatherFromApi(cityName: String, weatherResultListener: WeatherResultListener) {

        restService.getWeather("https://query.yahooapis" +
                ".com/v1/public/yql?q=select%20*%20from%20weather" +
                ".forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)" +
                "%20where%20text%3D%22" + cityName + "%22)&format=" +
                "json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
                .subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
                .subscribe(
                        {
//                    Responsee ->
//                    val response = Responsee
//                    println("respoonse $response")
                            e ->
                            Timber.d("response of request" + e)

                            weatherResultListener.onSuccess(e.toString())
                        },
                        { error ->
                            Log.e("error", error.message)

                        })


    }


    override fun cancel() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}