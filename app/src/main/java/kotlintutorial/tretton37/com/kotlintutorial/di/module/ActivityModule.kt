package kotlintutorial.tretton37.com.kotlintutorial.di.module

import dagger.Module
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseAppCompatActivity

/**
 * Created by ilkinartuc on 2017-06-28.
 */


@Module
class ActivityModule(private val baseActivity: BaseAppCompatActivity) {

//    @Provides
//    @ActivityScope
//    fun provideLocationServicesManager(bus: Bus): LocationServiceManager {
//        return LocationServiceManager(baseActivity, bus)
//    }

}
