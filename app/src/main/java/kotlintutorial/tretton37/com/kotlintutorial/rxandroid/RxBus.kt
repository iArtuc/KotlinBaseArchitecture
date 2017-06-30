package kotlintutorial.tretton37.com.kotlintutorial.rxandroid

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;


class RxBus {


    // If multiple threads are going to emit events to this
    // then it must be made thread-safe like this instead

//    private val _bus = SerializedSubject(PublishSubject.create<Any>())

    private val _bus = PublishSubject.create<Any>()

    fun send(o: Any) {
        _bus.onNext(o)
    }

    fun toObserverable(): Observable<Any> {
        return _bus
    }

    fun hasObservers(): Boolean {
        return _bus.hasObservers()
    }
}