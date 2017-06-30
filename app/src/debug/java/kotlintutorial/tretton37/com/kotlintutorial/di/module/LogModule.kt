package kotlintutorial.tretton37.com.kotlintutorial.di.module

import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

/**
 * Created by ilkinartuc on 2017-06-28.
 */


@Module
class LogModule {

    @Provides
    fun provideTimberTree(): Timber.Tree {
        return Timber.DebugTree()
        //TODO change to crashlytics tree when implement crashlytics
    }


    @Provides
    fun provideServiceLogLevel(): HttpLoggingInterceptor.Level {
        return HttpLoggingInterceptor.Level.BODY
    }
}