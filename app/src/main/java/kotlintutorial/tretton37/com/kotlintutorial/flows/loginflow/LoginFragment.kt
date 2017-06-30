package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlintutorial.tretton37.com.kotlintutorial.R
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseAppCompatActivity
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseFragment
import kotlintutorial.tretton37.com.kotlintutorial.di.module.FragmentModule
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.presenter.LoginFragmentPresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.view.LoginFragmentView
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-06-30.
 */
class LoginFragment : BaseFragment(), LoginFragmentView {


    @Inject
    protected lateinit var presenter: LoginFragmentPresenter

    override fun injectDependencies(activityComponent: BaseAppCompatActivity) {
        activityComponent.getComponent().plus(FragmentModule(this)).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)




        presenter.callTestFunc()


        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        presenter.start(this)

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

    override fun callToastFunc() {
        Timber.d("showToast")
    }
}