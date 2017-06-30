package kotlintutorial.tretton37.com.kotlintutorial.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlintutorial.tretton37.com.kotlintutorial.BaseApplication
import kotlintutorial.tretton37.com.kotlintutorial.BuildConfig
import kotlintutorial.tretton37.com.kotlintutorial.di.Names
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.RxBus
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.SchedulerProvider
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.SchedulerProviderImpl
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.Executors
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by ilkinartuc on 2017-06-29.
 */

@Module
class UtilityModule {

//    @Provides
//    @Singleton
//    fun provideBus(): Bus {
//        return Bus(ThreadEnforcer.MAIN)
//    }

    private val DATABASE_VERSION = 1

    @Provides
    @Singleton
    @Named(Names.DEFAULT_GSON)
    fun provideDefaultGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideConverter(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun providePicasso(baseApplication: BaseApplication): Picasso {
        return Picasso.Builder(baseApplication).loggingEnabled(BuildConfig.DEBUG)
                .executor(Executors.newSingleThreadExecutor())
                .build()
    }


    @Provides
    @Singleton
    fun provideRxBus(): RxBus {
        return RxBus()
    }


    @Provides
    @Singleton
    internal fun provideRealm(config: RealmConfiguration): Realm {
        Realm.setDefaultConfiguration(config)
        try {
            return Realm.getDefaultInstance()
        } catch (e: Exception) {
            Timber.e(e, "")
            Realm.deleteRealm(config)
            Realm.setDefaultConfiguration(config)
            return Realm.getDefaultInstance()
        }

    }

    @Provides
    @Singleton
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return SchedulerProviderImpl()
    }

}