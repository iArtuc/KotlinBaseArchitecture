package kotlintutorial.tretton37.com.kotlintutorial.rxandroid

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ilkinartuc on 2017-07-10 with awesomeness.
 */

// default schedulers
fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}