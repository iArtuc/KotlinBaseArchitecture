package kotlintutorial.tretton37.com.kotlintutorial.rxandroid;

import io.reactivex.Scheduler


interface SchedulerProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun io(): Scheduler
}
