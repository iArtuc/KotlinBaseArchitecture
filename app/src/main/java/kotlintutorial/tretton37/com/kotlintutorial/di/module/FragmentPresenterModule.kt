package kotlintutorial.tretton37.com.kotlintutorial.di.module

import dagger.Module
import dagger.Provides
import kotlintutorial.tretton37.com.kotlintutorial.di.scopes.FragmentScope
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor.LoginFragmentInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor.RegisterFragmentInteractor
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter.LoginFragmentPresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter.LoginFragmentPresenterImpl
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter.RegisterFragmentPresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter.RegisterFragmentPresenterImpl
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.RxBus

/**
 * Created by ilkinartuc on 2017-06-28.
 */


@Module
class FragmentPresenterModule {

    @Provides
    @FragmentScope
    fun provideLoginFragmentPresenter(interactor : LoginFragmentInteractor): LoginFragmentPresenter {
        return LoginFragmentPresenterImpl(interactor)
    }

    @Provides
    @FragmentScope
    fun provideRegisterFragmentPresenter(interactor : RegisterFragmentInteractor, bus : RxBus):
            RegisterFragmentPresenter {
        return RegisterFragmentPresenterImpl(interactor, bus)
    }


}
