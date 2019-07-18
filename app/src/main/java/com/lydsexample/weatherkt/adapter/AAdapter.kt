package com.lydsexample.weatherkt.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

abstract class AAdapter<T>(list : List<T>, context : Context, layoutId : Int) : BaseAdapter() {
    var list : List<T> = ArrayList();
    private var mContext:Context? = null;
    private var layoutId = 0;

    init {
        this.layoutId = layoutId;
        this.list = list;
        this.mContext = context;
    }

    override fun getView(p0: Int, p1: View, p2: ViewGroup): View {
        val viewHolder = ViewHolder.getHolder(mContext, p2, layoutId, p0, p1)
        convert(viewHolder, list.get(p0))
        viewHolder.getconvertView()
        return p1
    }

    override fun getItem(p0: Int): T {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    abstract fun convert(viewHolder: ViewHolder, t: T)

}