package kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.interactor

import kotlintutorial.tretton37.com.kotlintutorial.base.BaseInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.listener.MainActivityListener

/**
 * Created by ilkinartuc on 2017-06-29.
 */
interface MainActivityInteractor : BaseInteractor {


    fun loadMainActivity(testMainListener : MainActivityListener)


}