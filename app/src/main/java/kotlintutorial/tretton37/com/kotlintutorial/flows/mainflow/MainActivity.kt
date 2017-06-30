package kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import kotlintutorial.tretton37.com.kotlintutorial.R
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseAppCompatActivity
import kotlintutorial.tretton37.com.kotlintutorial.di.component.ApplicationComponent
import kotlintutorial.tretton37.com.kotlintutorial.di.module.ActivityModule
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.presenter.MainActivityPresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.view.MainScreenView
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.RxBus
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.events.testEvent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseAppCompatActivity(), MainScreenView {


    override fun callToastFunc() {
        Toast.makeText(baseContext, "callFuncFrom presenter", Toast.LENGTH_LONG).show()
    }


    @Inject
    protected lateinit var bus: RxBus

    @Inject
    protected lateinit var gson: Gson

    private lateinit var _subscriptions: CompositeDisposable


    @Inject
    protected lateinit var presenter: MainActivityPresenter


    override fun getActivityLayout(): Int {
        return R.layout.activity_main;
    }

    override fun injectDependencies(appComponent: ApplicationComponent) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        appComponent.plus(ActivityModule(this)).inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter.start(this)

        txt_header.text = "test"  //  kotlin handles the findview etc..  but names won't be nice
        txt_header.setOnClickListener(View.OnClickListener { callToastFunc() }) // click listener example


        rxBusTest()


        presenter.callTheLogFunction("test")



        presenter.getSomethingFromRetrofit()

    }

    private fun rxBusTest() {

        _subscriptions = CompositeDisposable()
        _subscriptions.add(bus.toObserverable().subscribe {
            event ->
            if (event is testEvent) {
                catchEvent()
            }

        })


        if (bus.hasObservers()) {
            bus.send(testEvent())
        }

    }

    private fun catchEvent() {

        println("activity catch event test")
    }


    class thread : Thread() {

        override fun run() {


            try {
                Thread.sleep(5000)
            } catch (ex: Exception) {
                println(ex.message)
            }

        }

    }


    override fun onDestroy() {
        super.onDestroy()
//        _subscriptions.unSubscribeIfNotNull()
        _subscriptions.clear()
        _subscriptions.dispose()

    }

}
