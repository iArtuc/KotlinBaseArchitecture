package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter

import kotlintutorial.tretton37.com.kotlintutorial.base.BasePresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.view.LoginFragmentView

/**
 * Created by ilkinartuc on 2017-07-03.
 */
interface LoginFragmentPresenter : BasePresenter<LoginFragmentView> {
    fun callTestFunc()
}