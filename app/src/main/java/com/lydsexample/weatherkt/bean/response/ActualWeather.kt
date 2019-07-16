package com.lydsexample.weatherkt.bean.response

class ActualWeather{
   var status: Int = 0
   var errorCode: Int = 0
   var errorMessage: String? = null
   var timestamp: Long? = null
   var data: Actual? = null

    class Actual{
       var cityInfo: CityInfo? = null
       var l: Ln? = null
    }

    class CityInfo{
       var areaId: String? = null
       var name: String? = null
       var district: String? = null
       var prov: String? = null
       var nation: String? = null
       var lon: String? = null
       var lat: String? = null
       var time: String? = null
       var timeZone: String? = null
       var zoneAbb: String? = null
    }

    class Ln{
       var l1: String? = null
       var l2: String? = null
       var l3: String? = null
       var l4: String? = null
       var l5: String? = null

       var l6: String? = null
       var l7: String? = null
       var l8: String? = null
       var l9: String? = null
       var l10: String? = null

       var l11: String? = null
       var l12: String? = null
       var aq: String? = null
       var uv: String? = null
    }

}