package com.lydsexample.weatherkt.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lydsexample.weatherkt.bean.City
import com.lydsexample.weatherkt.bean.response.WeekF

class WeekWeatherAdapter (layoutResId: Int, data: List<WeekF>) : BaseQuickAdapter<WeekF, BaseViewHolder>(data){
    override fun convert(helper: BaseViewHolder?, item: WeekF?) {

    }

}