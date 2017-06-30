package kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlintutorial.tretton37.com.kotlintutorial.R
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseAppCompatActivity
import kotlintutorial.tretton37.com.kotlintutorial.custom.CustomTextView
import kotlintutorial.tretton37.com.kotlintutorial.di.component.ApplicationComponent
import kotlintutorial.tretton37.com.kotlintutorial.di.module.ActivityModule
import kotlintutorial.tretton37.com.kotlintutorial.flows.mainflow.MainActivity
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.presenter.WeatherActivityPresenter
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.view.WeatherActivityView
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.RxBus
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.applySchedulers
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.events.testEvent
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.unSubscribeIfNotNull
import kotlinx.android.synthetic.main.activity_weather.*
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by ilkinartuc on 2017-07-07 with awesomeness.
 */
class WeatherActivity : BaseAppCompatActivity(), WeatherActivityView, LifecycleRegistryOwner {


    override fun getLifecycle() = lifecycleRegistry

    private val lifecycleRegistry by lazy { LifecycleRegistry(this) }

    val _subscriptions: CompositeDisposable = CompositeDisposable()

    @Inject
    protected lateinit var bus: RxBus

    @Inject
    protected lateinit var presenter: WeatherActivityPresenter

    lateinit var header: CustomTextView


    override fun showWeatherInfo(info: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injectDependencies(appComponent: ApplicationComponent) {
        appComponent.plus(ActivityModule(this)).inject(this)
    }

    override fun getActivityLayout(): Int {
        return R.layout.activity_weather
    }

    @BindView(R.id.txt_activity_weather_city_name_header) lateinit var headerText: CustomTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        ButterKnife.bind(this)
        header = txt_activity_weather_city_name_header

        presenter.start(this)



        showProgress()
        object : CountDownTimer(3000, 1000) {
            override fun onFinish() {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                presenter.getWeatherInCity("istanbul")
            }

            override fun onTick(millisUntilFinished: Long) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }.start()


        _subscriptions.add(bus.toObserverable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ event ->
                    if (event is testEvent) {
                        Timber.d("test catch weather activity")
                    }
                }))


//        header.setOnClickListener({
//            presenter.getWeatherInCity("ankara")
//        })


        headerText.text = "test    asd  "
        headerText.textSize = 20f
    }


    override fun showCityObservable(observable: Observable<Any>) {


        hideProgress()

        if (lifecycleRegistry.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
            // connect if not connected

        }

        _subscriptions.add(observable
                .applySchedulers()
                .subscribe({
                    e ->
                    Timber.d("showCityObser " + e)
                }))

    }


    companion object {
        private val TAG = "Weather Activity"
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        _subscriptions.unSubscribeIfNotNull()
    }

//    @OnClick(R.id.txt_activity_weather_city_name_header)
//    internal fun sayHello() {
//        Toast.makeText(this, "Hello, views!", Toast.LENGTH_SHORT).show()
//        presenter.getWeatherInCity("ankara")
//    }

    fun getWeather(v: View?) {
        Toast.makeText(this, "YOLO", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}



