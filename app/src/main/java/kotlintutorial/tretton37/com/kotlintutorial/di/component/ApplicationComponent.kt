package kotlintutorial.tretton37.com.kotlintutorial.di.component

import dagger.Component
import kotlintutorial.tretton37.com.kotlintutorial.di.module.*
import javax.inject.Singleton

/**
 * Created by ilkinartuc on 2017-06-28.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, LogModule::class, EndPointModule::class,
        RestServiceModule::class, UtilityModule::class))
interface ApplicationComponent : BaseApplicationComponent {

    fun plus(activityModule: ActivityModule): ActivityComponent
}