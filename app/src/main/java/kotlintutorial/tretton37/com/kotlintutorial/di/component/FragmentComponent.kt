package kotlintutorial.tretton37.com.kotlintutorial.di.component

import dagger.Subcomponent
import kotlintutorial.tretton37.com.kotlintutorial.di.module.FragmentModule
import kotlintutorial.tretton37.com.kotlintutorial.di.module.FragmentPresenterModule
import kotlintutorial.tretton37.com.kotlintutorial.di.scopes.FragmentScope
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.LoginFragment
import kotlintutorial.tretton37.com.kotlintutorial.flows.registerflow.RegisterFragment

/**
 * Created by ilkinartuc on 2017-06-28.
 */
@FragmentScope
@Subcomponent(modules = arrayOf(FragmentModule::class, FragmentPresenterModule::class))
interface FragmentComponent {

    fun inject(fragment: LoginFragment)

    fun inject(fragment: RegisterFragment)


}
