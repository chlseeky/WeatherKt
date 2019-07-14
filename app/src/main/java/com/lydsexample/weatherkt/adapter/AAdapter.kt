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

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val viewHolder = ViewHolder.getHolder(mContext, p2, layoutId, p0, p1)
        convert(viewHolder, list.get(p0))
        viewHolder.getconvertView()
    }

    override fun getItem(p0: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        p0
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return list.size
    }

    abstract fun convert(viewHolder: ViewHolder, t: T)

}