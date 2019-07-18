package com.lydsexample.weatherkt.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager

class NetWorkChangReceiver:  BroadcastReceiver(){
    override fun onReceive(p0: Context, intent: Intent) {
        if (WifiManager.WIFI_STATE_CHANGED_ACTION == intent.getAction()) {// 监听wifi的打开与关闭，与wifi的连接无关
            val wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0)
            //            Log.e("TAG", "wifiState:" + wifiState);
            when (wifiState) {
                WifiManager.WIFI_STATE_DISABLED -> {
                }
                WifiManager.WIFI_STATE_DISABLING -> {
                }
            }
        }
        // 监听网络连接，包括wifi和移动数据的打开和关闭,以及连接上可用的连接都会接到监听
        if (ConnectivityManager.CONNECTIVITY_ACTION == intent.getAction()) {
            //获取联网状态的NetworkInfo对象
            val info = intent.getParcelableExtra<NetworkInfo>(ConnectivityManager.EXTRA_NETWORK_INFO)
            if (info != null) {
                //如果当前的网络连接成功并且网络连接可用
                if (NetworkInfo.State.CONNECTED == info.getState() && info!!.isAvailable()) {
                    if (info!!.getType() == ConnectivityManager.TYPE_WIFI || info!!.getType() == ConnectivityManager.TYPE_MOBILE) {
//                        AWidgetUtils.updateWidgetDes(context)
                        //                        Log.e("TAG", getConnectionType(info.getType()) + "连上");
                    }
                } else {
//                    AWidgetUtils.updateWidgetDes(context)
                    //                    Log.e("TAG", getConnectionType(info.getType()) + "断开");
                }
            }
        }
    }
}