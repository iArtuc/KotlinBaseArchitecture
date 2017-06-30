package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.view

import kotlintutorial.tretton37.com.kotlintutorial.base.BaseView

/**
 * Created by ilkinartuc on 2017-07-03.
 */
interface RegisterFragmentView : BaseView {

//    fun callRegisterFunction(email: String, password: String)


    fun registerComplete()
    fun registerFailed(message: String)

}