package kotlintutorial.tretton37.com.kotlintutorial.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlintutorial.tretton37.com.kotlintutorial.BaseApplication
import javax.inject.Singleton

/**
 * Created by ilkinartuc on 2017-06-28.
 */


@Module
class AppModule(private val application: BaseApplication) {

    @Provides
    @Singleton
    fun provideApplication(): BaseApplication {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }


}
