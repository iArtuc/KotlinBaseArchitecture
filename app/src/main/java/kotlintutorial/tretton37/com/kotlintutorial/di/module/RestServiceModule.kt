package kotlintutorial.tretton37.com.kotlintutorial.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import kotlintutorial.tretton37.com.kotlintutorial.di.Names
import kotlintutorial.tretton37.com.kotlintutorial.di.qualifier.ApplicationQualifier
import kotlintutorial.tretton37.com.kotlintutorial.restservices.RestService
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by ilkinartuc on 2017-06-28.
 */

@Module
class RestServiceModule {

    @Provides @Singleton
    fun provideCache(@ApplicationQualifier context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024.toLong())

    @Provides
    @Singleton
    internal fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideLoggingCapableHttpClient(logLevel: HttpLoggingInterceptor.Level):
            OkHttpClient {


//        val client = OkHttpClient().newBuilder()
//                .cache(cache)
//                .addInterceptor(LastFmRequestInterceptor(apiKey, cacheDuration))
//                .addInterceptor(HttpLoggingInterceptor().apply {
//                    level = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
//                })
//                .build()
//    }


//        val logging = HttpLoggingInterceptor().apply {
//            level = if (BuildConfig.DEBUG) {
//                HttpLoggingInterceptor.Level.BODY
//            } else {
//                HttpLoggingInterceptor.Level.NONE
//            }
//        }


        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.tag("retrofit").d(message) })

        logging.level = logLevel
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient, gson: Gson, rxJavaCallAdapterFactory:
    RxJava2CallAdapterFactory): Retrofit.Builder {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .client(okHttpClient)
    }

    @Provides
    @Singleton
    fun provideRestService(retrofitBuilder: Retrofit.Builder,
                           @Named(Names.BASE_URL_END_POINT) baseUrl: String): RestService {
        return retrofitBuilder.baseUrl(baseUrl)
                .build()
                .create<RestService>(RestService::class.java)
    }


    @Provides
    @Singleton
    fun provideGsonConverter(): Gson {
        return GsonBuilder().create()
    }


}
