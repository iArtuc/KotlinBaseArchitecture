package kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.presenter

import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.interactor.MainActivityInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.listener.MainActivityListener
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.view.MainScreenView
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-06-29.
 */


class MainActivityPresenterImpl @Inject constructor(val mainActivityInteractor: MainActivityInteractor) : MainActivityPresenter {
    override fun subscribe() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        RxUtils().unsubscribe(subscriptions)
    }


    lateinit var view: MainScreenView

    override fun start(view: MainScreenView) {
        this.view = view;
    }

    override fun callTheLogFunction(string: String) {
        view.callToastFunc()
    }

    override fun getSomethingFromRetrofit() {


        mainActivityInteractor.loadMainActivity(object : MainActivityListener {
            override fun onSuccess(string: String) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(message: String) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


        })
    }

}