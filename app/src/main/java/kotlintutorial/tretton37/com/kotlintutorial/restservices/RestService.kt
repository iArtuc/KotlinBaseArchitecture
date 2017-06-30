package kotlintutorial.tretton37.com.kotlintutorial.restservices

import io.reactivex.Observable
import kotlintutorial.tretton37.com.kotlintutorial.flows.weatherFlow.model.WeatherResponse
import kotlintutorial.tretton37.com.kotlintutorial.restservices.response.AreaRestResponse
import kotlintutorial.tretton37.com.kotlintutorial.restservices.response.model.User
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by ilkinartuc on 2017-06-28.
 */
interface RestService {


    @POST("test")
    fun test(@Body request: String): Call<String>

    @GET("api/areas")
    abstract fun getAreasObservable(@Query("area_id") param1: Int): Observable<AreaRestResponse>


    @GET("api/areas")
    fun getAreasRet(@Query("area_id") param1: Int): Call<AreaRestResponse>


    @POST("UserList/UserInfo.json")
    fun sendUserInfoObservable(@Body user: User): Call<User>


    @POST("message/User.json")
    fun sendUserInfoStringObservable(@Body user: User): Observable<User>


    @GET("UserList/UserInfo.json")
    fun getUserList(): Observable<Any>
//
//    @POST("/upload/{new}.json")
//    fun setData(@Path("new") s1: String, @Body user: User): Call<User>


    @GET
    fun getWeather(@Url url: String): Observable<WeatherResponse>


}
