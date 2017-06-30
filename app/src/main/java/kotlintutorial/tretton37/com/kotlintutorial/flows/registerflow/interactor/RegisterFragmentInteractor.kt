package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor

import kotlintutorial.tretton37.com.kotlintutorial.base.BaseInteractor

/**
 * Created by ilkinartuc on 2017-07-03.
 */
interface RegisterFragmentInteractor : BaseInteractor {


    fun registerFunction(email: String, password: String)

}