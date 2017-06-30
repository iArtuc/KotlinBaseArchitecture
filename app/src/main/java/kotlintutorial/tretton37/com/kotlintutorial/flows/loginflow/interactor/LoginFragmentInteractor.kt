package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor

import kotlintutorial.tretton37.com.kotlintutorial.base.BaseInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.listener.LoginFragmentListener

/**
 * Created by ilkinartuc on 2017-07-03.
 */
interface LoginFragmentInteractor : BaseInteractor {


    fun sendUserInfo(testLoginListener : LoginFragmentListener)

    fun sendLoginUserInfo(loginListener : LoginFragmentListener)


}