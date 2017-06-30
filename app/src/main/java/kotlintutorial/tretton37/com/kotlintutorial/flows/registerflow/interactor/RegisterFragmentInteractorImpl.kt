package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor

import kotlintutorial.tretton37.com.kotlintutorial.restservices.RestService
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.RxBus
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.events.testEvent
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-07-03.
 */


class RegisterFragmentInteractorImpl @Inject constructor(val restService: RestService, val bus: RxBus) : RegisterFragmentInteractor {

    override fun registerFunction(email: String, password: String) {

        if (bus.hasObservers()) {
            bus.send(testEvent())
        }

//        Realm.

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cancel() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}