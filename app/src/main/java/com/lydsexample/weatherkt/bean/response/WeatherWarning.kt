package com.lydsexample.weatherkt.bean.response

class WeatherWarning {
    var status: Int = 0
    var errorCode: Int = 0
    var errorMessage: String? = null
    var timestamp: Long? = null
    var data: Data? = null

    class Data{
        var w: List<Warn>? = null
    }
}