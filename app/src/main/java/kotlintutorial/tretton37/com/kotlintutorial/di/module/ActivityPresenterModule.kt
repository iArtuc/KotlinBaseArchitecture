package kotlintutorial.tretton37.com.kotlintutorial.di.module

import dagger.Binds
import dagger.Module
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.presenter.MainActivityPresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.presenter.MainActivityPresenterImpl
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.presenter.WeatherActivityPresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.presenter.WeatherActivityPresenterImpl

/**
 * Created by ilkinartuc on 2017-06-28.
 */


@Module
abstract class ActivityPresenterModule {


//    @Provides
//    @ActivityScope
//    fun provideMainActivityPresenter(interactor: MainActivityInteractor): MainActivityPresenter {
//        return MainActivityPresenterImpl(interactor)
//    }


    @Binds
    abstract fun provideMainActivityPresenter(mainActivityPresenter: MainActivityPresenterImpl):
            MainActivityPresenter

//    @Provides
//    @ActivityScope
//    fun provideWeatherActivityPresenter(interactor: WeatherActivityInteractor, rxBus: RxBus):
//            WeatherActivityPresenter {
//        return WeatherActivityPresenterImpl(interactor, rxBus)
//    }

    @Binds
    abstract fun bindweatherActivityPresenter(weatherActivityPresenter: WeatherActivityPresenterImpl):
            WeatherActivityPresenter


}
