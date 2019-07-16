package com.lydsexample.weatherkt.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lydsexample.weatherkt.bean.City

class SearchAdapter (layoutResId: Int, data: List<City>) : BaseQuickAdapter<City, BaseViewHolder>(data){
    override fun convert(helper: BaseViewHolder?, item: City?) {

    }

}