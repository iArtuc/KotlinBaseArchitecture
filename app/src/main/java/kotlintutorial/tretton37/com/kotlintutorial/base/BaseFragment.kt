package kotlintutorial.tretton37.com.kotlintutorial.base

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import rx.subscriptions.CompositeSubscription

/**
 * Created by ilkinartuc on 2017-06-28.
 */


abstract class BaseFragment : Fragment(), LifecycleRegistryOwner {


    private val lifecycleRegistry by lazy { LifecycleRegistry(this) }

    override fun getLifecycle() = lifecycleRegistry


    lateinit var activity: BaseAppCompatActivity

    protected var subscriptions = CompositeSubscription()

    abstract fun injectDependencies(activityComponent: BaseAppCompatActivity)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as BaseAppCompatActivity
        injectDependencies(activity)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDetach() {
        super.onDetach()
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }

}
