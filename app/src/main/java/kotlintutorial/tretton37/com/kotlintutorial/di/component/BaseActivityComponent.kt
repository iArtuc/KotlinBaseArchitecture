package kotlintutorial.tretton37.com.kotlintutorial.di.component

import kotlintutorial.tretton37.com.kotlintutorial.base.BaseAppCompatActivity
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.LoginActivity
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.MainActivity
import kotlintutorial.tretton37.com.kotlintutorial.flows.registerflow.RegisterActivity
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.WeatherActivity

/**
 * Created by ilkinartuc on 2017-06-28.
 */
interface BaseActivityComponent {

    fun inject(activity: MainActivity)

    fun inject(activity: LoginActivity)

    fun inject(activity: RegisterActivity)

    fun inject(activity: WeatherActivity)

    fun inject(activity: BaseAppCompatActivity)

}