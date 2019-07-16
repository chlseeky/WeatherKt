package com.lydsexample.weatherkt.bean.response

class RspRefreshToken {
    var status: Int = 0
    var errorCode: Int = 0
    var errorMessage: String? = null
    var timestamp: Long? = null
    var data: Token? = null

    class Token{
        var access_token: String? = null
        var refresh_token: String? = null
        var expires_in: Long? = null
        var scope: String? = null
    }
}