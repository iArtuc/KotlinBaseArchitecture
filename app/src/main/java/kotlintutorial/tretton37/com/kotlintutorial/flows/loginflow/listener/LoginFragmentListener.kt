package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.listener

import kotlintutorial.tretton37.com.kotlintutorial.mvp.listener.BaseListener

/**
 * Created by ilkinartuc on 2017-07-03.
 */

interface LoginFragmentListener : BaseListener {
    fun onSuccess(string: String)

}