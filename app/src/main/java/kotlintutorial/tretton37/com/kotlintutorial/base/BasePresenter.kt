package kotlintutorial.tretton37.com.kotlintutorial.base

/**
 * Created by ilkinartuc on 2017-06-29.
 */
interface BasePresenter<T : BaseView> {
    fun start(view: T)

    fun subscribe()

    fun unsubscribe()
}