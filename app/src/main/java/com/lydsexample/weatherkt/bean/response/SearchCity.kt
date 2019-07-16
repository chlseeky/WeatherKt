package com.lydsexample.weatherkt.bean.response

import com.lydsexample.weatherkt.bean.City

class SearchCity {
    var status: Int = 0
    var errorCode: Int = 0
    var errorMessage: String? = null
    var timestamp: Long? = null
    var data: CityInfos? = null

    class CityInfos{
        var cityInfos: List<City>? = null
    }
}