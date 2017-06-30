package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter

import kotlintutorial.tretton37.com.kotlintutorial.base.BasePresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.view.RegisterFragmentView

/**
 * Created by ilkinartuc on 2017-07-03.
 */
interface RegisterFragmentPresenter : BasePresenter<RegisterFragmentView> {

    fun callRegisterFunction(email: String, password: String)
    fun removeSubs()

}