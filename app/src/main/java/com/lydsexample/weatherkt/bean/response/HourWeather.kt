package com.lydsexample.weatherkt.bean.response

class HourWeather {
    var status: Int = 0
    var errorCode: Int = 0
    var errorMessage: String? = null
    var timestamp: Long? = null
    var data: Data? = null

    class Data{
        var jh: List<JH>? = null
    }

    class JH{
        var ja: String? = null
        var jb: String? = null
        var jc: String? = null
        var jd: String? = null
        var je: String? = null
        var jf: String? = null
    }
}