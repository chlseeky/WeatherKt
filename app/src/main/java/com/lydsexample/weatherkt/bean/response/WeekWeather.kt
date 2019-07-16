package com.lydsexample.weatherkt.bean.response

class WeekWeather {
    var status: Int = 0
    var errorCode: Int = 0
    var errorMessage: String? = null
    var timestamp: Long? = null
    var data: Data? = null

    inner class Data {
        var c: LocationC? = null
        var f: WeatherF? = null
    }

    inner class LocationC {
        var c1: String? = null
        var c2: String? = null
        var c3: String? = null
        var c4: String? = null
        var c5: String? = null

        var c6: String? = null
        var c7: String? = null
        var c8: String? = null
        var c9: String? = null
        var c10: String? = null

        var c11: String? = null
        var c12: String? = null
        var c13: String? = null
        var c14: String? = null
        var c15: String? = null

        var c16: String? = null
        var c17: String? = null
        var c18: String? = null
        var c19: String? = null
    }

    inner class WeatherF {
        var f1: List<WeekF>? = null
        var f0: String? = null
    }
}