package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter

import io.reactivex.disposables.CompositeDisposable
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor.RegisterFragmentInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.view.RegisterFragmentView
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.RxBus
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.events.testEvent
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.unSubscribeIfNotNull
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-07-03.
 */


class RegisterFragmentPresenterImpl @Inject constructor(val registerFragmentInteractor: RegisterFragmentInteractor, val bus: RxBus) : RegisterFragmentPresenter {
    override fun subscribe() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeSubs() {
//        _subscriptions.unSubscribeIfNotNull()
        _subscriptions.unSubscribeIfNotNull()
    }

    private lateinit var _subscriptions: CompositeDisposable


    override fun start(view: RegisterFragmentView) {
        this.view = view
    }

    override fun callRegisterFunction(email: String, password: String) {


        _subscriptions = CompositeDisposable()
        _subscriptions.add(bus.toObserverable().subscribe {
            event ->
            if (event is testEvent) {
                Timber.d("catch from interactor")
            }

        })


        registerFragmentInteractor.registerFunction(email, password)


    }


    lateinit var view: RegisterFragmentView


}