package kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.interactor

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlintutorial.tretton37.com.kotlintutorial.flows.loginflow.listener.LoginFragmentListener
import kotlintutorial.tretton37.com.kotlintutorial.restservices.RestService
import kotlintutorial.tretton37.com.kotlintutorial.restservices.response.model.User
import kotlintutorial.tretton37.com.kotlintutorial.rxandroid.SchedulerProvider
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ilkinartuc on 2017-07-03.
 */


class LoginFragmentInteractorImpl @Inject constructor(val restService: RestService, val schedulerProvider: SchedulerProvider) :
        LoginFragmentInteractor {


    override fun sendLoginUserInfo(loginListener: LoginFragmentListener) {
        // Write a message to the database

//        val database = FirebaseDatabase.getInstance()
//        val myRef = database.getReference("message").child("User")
//        myRef.setValue("Hello, World!")
    }

    override fun sendUserInfo(testLoginListener: LoginFragmentListener) {
        val user: User = User("ilkin")
        user.name = "hilal artuc"




        restService.sendUserInfoStringObservable(user)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { areaResponse ->
                            val response = areaResponse
                            println("respoonse $response")
                        },
                        { error ->
                            Timber.e("error", error.message)
                        })

//        database.child("users").child("userId").setValue(user);


        restService.getUserList()
                .subscribeOn(schedulerProvider.io())
                .unsubscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                        { areaResponse ->
                            val response = areaResponse
                            println("respoonse $response")
                        },
                        { error ->
                            Timber.e("error", error.message)
                        })

    }


    override fun cancel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

