package kotlintutorial.tretton37.com.kotlintutorial.di.module

import dagger.Binds
import dagger.Module
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor.LoginFragmentInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor.LoginFragmentInteractorImpl
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor.RegisterFragmentInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor.RegisterFragmentInteractorImpl
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.interactor.MainActivityInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.interactor.MainActivityInteractorImpl
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.interactor.WeatherActivityInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.interactor.WeatherActivityInteractorImpl

/**
 * Created by ilkinartuc on 2017-06-29.
 */
@Module
abstract class InteractorPresenterModule {


//    @Provides
//    @ActivityScope
//    fun provideMainActivityInteractor(restService: RestService, schedulerProvider: SchedulerProvider): MainActivityInteractor {
//        return MainActivityInteractorImpl(restService, schedulerProvider)
//    }

//    @Provides
//    @ActivityScope
//    fun provideLoginFragmentInteractor(restService: RestService, schedulerProvider: SchedulerProvider): LoginFragmentInteractor {
//        return LoginFragmentInteractorImpl(restService, schedulerProvider)
//    }


//    @Provides
//    @ActivityScope
//    fun provideRegisterFragmentInteractor(restService: RestService, bus: RxBus):
//            RegisterFragmentInteractor {
//        return RegisterFragmentInteractorImpl(restService, bus)
//    }

//    @Provides
//    @ActivityScope
//    fun provideWeatherActivityInteractor(restService: RestService, schedulerProvider:
//    SchedulerProvider):
//            WeatherActivityInteractor {
//        return WeatherActivityInteractorImpl(restService, schedulerProvider)
//    }


    @Binds
    abstract fun provideMainActivityInteractor(mainActivityInteractor: MainActivityInteractorImpl):
            MainActivityInteractor

    @Binds
    abstract fun provideLoginFragmentInteractor(loginFragmentInteractor:
                                                LoginFragmentInteractorImpl):
            LoginFragmentInteractor


    @Binds
    abstract fun provideRegisterFragmentInteractor(registerFragmentInteractor:
                                                   RegisterFragmentInteractorImpl):
            RegisterFragmentInteractor


    @Binds
    abstract fun provideWeatherActivityInteractor(weatherActivityInteractor:
                                                  WeatherActivityInteractorImpl):
            WeatherActivityInteractor


}