package kotlintutorial.tretton37.com.kotlintutorial.base

/**
 * Created by ilkinartuc on 2017-06-29.
 */
interface BaseView
{
    fun showProgress()

    fun hideProgress()

    fun showMessage(message: String = "There has been an error")
}
