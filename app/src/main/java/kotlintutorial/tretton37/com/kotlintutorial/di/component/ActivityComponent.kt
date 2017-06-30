package kotlintutorial.tretton37.com.kotlintutorial.di.component

import dagger.Subcomponent
import kotlintutorial.tretton37.com.kotlintutorial.di.module.ActivityModule
import kotlintutorial.tretton37.com.kotlintutorial.di.module.ActivityPresenterModule
import kotlintutorial.tretton37.com.kotlintutorial.di.module.FragmentModule
import kotlintutorial.tretton37.com.kotlintutorial.di.module.InteractorPresenterModule
import kotlintutorial.tretton37.com.kotlintutorial.di.scopes.ActivityScope

/**
 * Created by ilkinartuc on 2017-06-28.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class, ActivityPresenterModule::class,
        InteractorPresenterModule::class))
interface ActivityComponent : BaseActivityComponent {
    operator fun plus(fragmentModule: FragmentModule): FragmentComponent
}