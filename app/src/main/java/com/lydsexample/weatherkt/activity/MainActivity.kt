package com.lydsexample.weatherkt.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lydsexample.weatherkt.R
import com.lydsexample.weatherkt.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
