package kotlintutorial.tretton37.com.kotlintutorial

import android.app.Application
import butterknife.ButterKnife
import com.google.gson.Gson
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlintutorial.tretton37.com.kotlintutorial.di.component.ApplicationComponent
import kotlintutorial.tretton37.com.kotlintutorial.di.component.DaggerApplicationComponent
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.RxBus
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.applySchedulers
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.events.testEvent
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-06-28.
 */


class BaseApplication : Application() {

//    @Inject
//    var businessService: BusinessService? = null
//        internal set
//    @Inject
//    internal var sharedPreferencesManager: SharedPreferencesManager? = null
//    @Inject
//    internal var basketManager: BasketManager? = null
//    @Inject
//    internal var userManager: UserManager? = null
//    @Inject
//    internal var gson: Gson? = null

    @Inject lateinit var gson: Gson

    @Inject
    protected lateinit var bus: RxBus
    private lateinit var _subscriptions: CompositeDisposable

    lateinit var refWatcher: RefWatcher

    companion object {
        @JvmStatic lateinit var instance: BaseApplication
        @JvmStatic lateinit var appComponent: ApplicationComponent
    }


    override fun onCreate() {
        super.onCreate()
//        Fabric.with(this, Crashlytics())

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        refWatcher = LeakCanary.install(this)
        ButterKnife.setDebug(BuildConfig.DEBUG);
        // Initialize Realm. Should only be done once when the application starts.
        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

        instance = this
        setupMainComponent()


        testingForBus()


    }

    private fun testingForBus() {  // testing for catching event with RxKotlin/RxBus

        _subscriptions = CompositeDisposable()
        _subscriptions.add(bus.toObserverable()
                .applySchedulers()
                .subscribe {
                    event ->
                    if (event is testEvent) {
                        println("Application eventCatch")
                    }

                })
    }

    private fun setupMainComponent() {
        appComponent = DaggerApplicationComponent.create()
        appComponent.inject(this)
        //        appComponent = DaggerAppComponent.create()
    }

}
