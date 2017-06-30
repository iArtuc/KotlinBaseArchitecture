package kotlintutorial.tretton37.com.kotlintutorial.flows.registerflow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import kotlintutorial.tretton37.com.kotlintutorial.R
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseAppCompatActivity
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseFragment
import kotlintutorial.tretton37.com.kotlintutorial.di.module.FragmentModule
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter.RegisterFragmentPresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.view.RegisterFragmentView
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.RxBus
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.events.testEvent
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-07-04.
 */


class RegisterFragment : BaseFragment(), RegisterFragmentView {


    override fun registerComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerFailed(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    @Inject
    protected lateinit var presenter: RegisterFragmentPresenter

    @Inject protected lateinit var bus: RxBus


    private lateinit var _subscriptions: CompositeDisposable

    override fun injectDependencies(activityComponent: BaseAppCompatActivity) {
        activityComponent.getComponent().plus(FragmentModule(this)).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)




        presenter.callRegisterFunction("ilkin", "asd")


        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        presenter.start(this)


        _subscriptions = CompositeDisposable()
        _subscriptions.add(bus.toObserverable().subscribe {
            event ->
            if (event is testEvent) {
                Timber.d("catch from interactor in fragment")
            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.removeSubs()
    }


    override fun showProgress() {
        showProgress()
    }

    override fun hideProgress() {
        hideProgress()
    }

    override fun showMessage(message: String) {
        Timber.i("test" + message)
    }

}