package kotlintutorial.tretton37.com.kotlintutorial.rxandroid

import io.reactivex.disposables.Disposable
import rx.Subscription

/**
 * Created by ilkinartuc on 2017-06-29.
 */


fun Subscription?.unSubscribeIfNotNull() {
    this?.unsubscribe()
}

fun Disposable?.unSubscribeIfNotNull() {
    this?.dispose()
}
