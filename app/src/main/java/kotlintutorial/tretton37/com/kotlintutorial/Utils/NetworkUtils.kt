package kotlintutorial.tretton37.com.kotlintutorial.Utils

import android.content.Context
import android.net.ConnectivityManager
import io.reactivex.Observable


/**
 * Created by ilkinartuc on 2017-07-11 with awesomeness.
 */
object NetworkUtils {


    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }


    fun isNetworkAvailableObservable(context: Context): Observable<Boolean> {
        return Observable.just(NetworkUtils.isNetworkAvailable(context))
    }

}