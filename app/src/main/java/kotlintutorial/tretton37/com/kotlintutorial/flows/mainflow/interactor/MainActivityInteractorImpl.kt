package kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.interactor

import android.util.Log
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.listener.MainActivityListener
import kotlintutorial.tretton37.com.kotlintutorial.restservices.RestService
import kotlintutorial.tretton37.com.kotlintutorial.restservices.response.AreaRestResponse
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.SchedulerProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-06-29.
 */
class MainActivityInteractorImpl @Inject constructor(val restService: RestService,
                                                     val schedulerProvider: SchedulerProvider) :
        MainActivityInteractor {


    override fun loadMainActivity(testMainListener: MainActivityListener) {

        restService.getAreasObservable(1)
                .subscribeOn(schedulerProvider.io())
                .unsubscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                        { areaResponse ->
                            val response = areaResponse
                            println("respoonse $response")
                        },
                        { error ->
                            Log.e("error", error.message)
                        })


        restService.getAreasRet(1).enqueue(object : Callback<AreaRestResponse> {
            override fun onFailure(call: Call<AreaRestResponse>?, t: Throwable?) {
                testMainListener.onFailure(t.toString())
            }

            override fun onResponse(call: Call<AreaRestResponse>?, response: Response<AreaRestResponse>?) {
                println("test $response")
            }

        })
    }


    override fun cancel() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}