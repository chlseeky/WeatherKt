package com.lydsexample.weatherkt.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.lydsexample.weatherkt.utils.AConstants
import com.lydsexample.weatherkt.utils.SPUtils

class BootCompleteReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
        }
    }
}