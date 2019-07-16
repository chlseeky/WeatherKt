package com.lydsexample.weatherkt.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lydsexample.weatherkt.bean.TypeBean

class DialogAdapter(layoutResId: Int, data: List<TypeBean>) : BaseQuickAdapter<TypeBean,BaseViewHolder>(data) {

    override fun convert(helper: BaseViewHolder?, item: TypeBean?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}