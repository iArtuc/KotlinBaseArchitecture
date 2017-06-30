package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter

import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor.LoginFragmentInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.listener.LoginFragmentListener
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.view.LoginFragmentView
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-07-03.
 */
class LoginFragmentPresenterImpl : LoginFragmentPresenter {
    override fun unsubscribe() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribe() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    val loginFragmentInteractor: LoginFragmentInteractor

    override fun callTestFunc() {


        loginFragmentInteractor.sendUserInfo(object : LoginFragmentListener{
            override fun onSuccess(string: String) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(message: String) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        view.callToastFunc()
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start(view: LoginFragmentView) {
        this.view = view
    }


    lateinit var view: LoginFragmentView

    @Inject constructor(loginFragmentInteractor: LoginFragmentInteractor) {
        this.loginFragmentInteractor = loginFragmentInteractor

    }


}