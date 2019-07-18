package com.lydsexample.weatherkt.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.lydsexample.weatherkt.callback.LanguageChange
import com.lydsexample.weatherkt.utils.AConstants
import org.greenrobot.eventbus.EventBus

class LocaleChangeReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.getAction() == Intent.ACTION_LOCALE_CHANGED) {
            //更新通知的文本
//            context.startForegroundService(Intent(context, WeatherUpdateService::class.java))
            AConstants.reloadConstant()
            if (isZh(context)) {
                EventBus.getDefault().post(LanguageChange(true))
            } else {
                EventBus.getDefault().post(LanguageChange(false))
            }
        }
    }

    fun isZh(context: Context): Boolean {
        val locale = context.resources.configuration.locale
        val language = locale.language
        return if (language.endsWith("zh"))
            true
        else
            false
    }

}