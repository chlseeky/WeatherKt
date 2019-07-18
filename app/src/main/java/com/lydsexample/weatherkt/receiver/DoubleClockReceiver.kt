package com.lydsexample.weatherkt.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.lydsexample.weatherkt.utils.AConstants

class DoubleClockReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?,inten: Intent) {
        if (inten.action == AConstants.ACTION_WEATHER_DOUBLE_CLOCK_STATUS_CHANGE) {
            //            AWidgetUtils.updateWidget(context);
        }
    }
}