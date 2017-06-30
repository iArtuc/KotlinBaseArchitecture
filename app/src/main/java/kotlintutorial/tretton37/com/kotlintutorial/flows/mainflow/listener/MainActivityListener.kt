package kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.listener

import kotlintutorial.tretton37.com.kotlintutorial.mvp.listener.BaseListener

/**
 * Created by ilkinartuc on 2017-06-29.
 */
interface MainActivityListener : BaseListener {
    fun onSuccess(string: String)

}