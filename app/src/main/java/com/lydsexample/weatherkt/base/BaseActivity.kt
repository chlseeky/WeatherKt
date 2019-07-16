package com.lydsexample.weatherkt.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import com.lydsexample.weatherkt.R
import com.lydsexample.weatherkt.net.WeatherService
import com.lydsexample.weatherkt.utils.ToastUtils

open class BaseActivity : AppCompatActivity() {
    var apiService: WeatherService? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStatusBar(Color.WHITE)
    }

    fun setStatusBar(color: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = color

        if (isLightColor(color)) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
    }

    private fun isLightColor(color: Int): Boolean {
        return ColorUtils.calculateLuminance(color) >= 0.5
    }

    fun toast(@StringRes message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    fun showNetError(errorCode: Int) {
        when (errorCode) {
            0 ->
                ToastUtils.showShort(R.string.success)
            500 ->
                ToastUtils.showShort(R.string.inner_error)
            1401 ->
                ToastUtils.showShort(R.string.token_invalid)
            1403 ->
                ToastUtils.showShort(R.string.lack_permission)
            1500 ->
                ToastUtils.showShort(R.string.over_time)
            1601 ->
                ToastUtils.showShort(R.string.param_error)
            1801 ->
                ToastUtils.showShort(R.string.no_info);
            1802 ->
                ToastUtils.showShort(R.string.lat_long_error)
        }
    }

    override fun onPause() {
        super.onPause()
        ToastUtils.cancel()
    }

}