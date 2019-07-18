package com.lydsexample.weatherkt.net

import com.google.gson.Gson
import com.lydsexample.weatherkt.utils.AConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WeatherApiClient {
    private lateinit var retrofitAuth: Retrofit
    private lateinit var retrofitWeather: Retrofit
    private val DEFAULT_TIMEOUT: Long = 5

    fun getAuthClient(): Retrofit {
        if (retrofitAuth == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            //            OkHttpClient client = new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS).addInterceptor(logging).build();
            val client = OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                //                    .addInterceptor(logging)//打印网络请求日志，提交代码时请注销
                .build()

            retrofitAuth = Retrofit.Builder()
                .baseUrl(WeatherService.BASE_AUTH_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                //                    .client(getUnsafeOkHttpClient())
                .build()
        }
        return retrofitAuth
    }

    fun getWeatherClient(): Retrofit {
        if (retrofitWeather == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            //            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();
            val client = OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                //                    .addInterceptor(logging)
                .build()
            retrofitWeather = Retrofit.Builder()
                .baseUrl(WeatherService.BASE_WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                //                    .client(getUnsafeOkHttpClient())
                .build()
        }
        return retrofitWeather
    }
}