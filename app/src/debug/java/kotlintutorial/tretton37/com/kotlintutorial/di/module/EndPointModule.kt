package kotlintutorial.tretton37.com.kotlintutorial.di.module

import dagger.Module
import dagger.Provides
import kotlintutorial.tretton37.com.kotlintutorial.di.Names
import kotlintutorial.tretton37.com.kotlintutorial.restservices.BaseUrl
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by ilkinartuc on 2017-06-28.
 */
@Module
class EndPointModule {

    @Provides
    @Singleton
    @Named(Names.BASE_URL_END_POINT)
    fun provideBaseUrl(): String {
        return BaseUrl.SERVICE_BASE_URL
    }

}
