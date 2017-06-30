package kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.presenter

import kotlintutorial.tretton37.com.kotlintutorial.base.BasePresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.view.MainScreenView

/**
 * Created by ilkinartuc on 2017-06-29.
 */


interface MainActivityPresenter : BasePresenter<MainScreenView> {
    fun callTheLogFunction(string: String)


    fun getSomethingFromRetrofit()
}