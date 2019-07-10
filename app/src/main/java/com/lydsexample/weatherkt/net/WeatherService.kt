package com.lydsexample.weatherkt.net

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

interface WeatherService {
//    val BASE_AUTH_URL = "http://47.107.253.85"
//    val BASE_WEATHER_URL = "http://47.106.208.78"

//    @GET("/oauth2/access_token")
//    fun getToken(@QueryMap queryMap: Map<String, Any>): Call<RspToken>

//    @GET("/oauth2/refresh_token")
//    fun refreshToken(@QueryMap queryMap: Map<String, Any>): Call<RspRefreshToken>

    @GET("/weather/city/search")
    fun searchCity(@Header("access_token") token: String, @QueryMap queryMap: Map<String, String>): Call<JsonObject>
//    Call<SearchCity> searchCity(@Header("access_token") String token, @QueryMap Map<String,String> queryMap);

    @GET("/weather/week/normal")
    fun getWeekWeather(@Header("access_token") token: String, @QueryMap queryMap: Map<String, String>): Call<JsonObject>
//    Call<WeekWeather> getWeekWeather(@Header("access_token") String token, @QueryMap Map<String,String> queryMap);

    @GET("/weather/actual")
    fun getActualWeather(@Header("access_token") token: String, @QueryMap queryMap: Map<String, String>): Call<JsonObject>
//    Call<ActualWeather> getActualWeather(@Header("access_token") String token, @QueryMap Map<String,String> queryMap);

    @GET("/weather/hour")
    fun getHourWeather(@Header("access_token") token: String, @QueryMap queryMap: Map<String, String>): Call<JsonObject>
//    Call<HourWeather> getHourWeather(@Header("access_token") String token, @QueryMap Map<String,String> queryMap);

    @GET("/weather/warning")
    fun getWarning(@Header("access_token") token: String, @QueryMap queryMap: Map<String, String>): Call<JsonObject>
//    Call<WeatherWarning> getWarning(@Header("access_token") String token, @QueryMap Map<String,String> queryMap);

//    @GET("/weather/locate")
//    fun locate(@Header("access_token") token: String, @QueryMap queryMap: Map<String, String>): Call<GEOLocate>
}