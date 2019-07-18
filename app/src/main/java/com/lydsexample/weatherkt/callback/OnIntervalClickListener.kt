package com.lydsexample.weatherkt.callback

interface OnIntervalClickListener {
    abstract fun intervalClick(interval: Long)
    abstract fun unitClick(unit: String)
}