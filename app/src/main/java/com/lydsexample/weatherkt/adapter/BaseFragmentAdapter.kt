package com.lydsexample.weatherkt.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

abstract class BaseFragmentAdapter(fm: FragmentManager?, fragmentList: List<Fragment>, titles: List<String>) : FragmentStatePagerAdapter(fm) {
    var titles: List<String>? = null
    var mFragments: List<Fragment>? = null

    override fun getCount(): Int {
        return isEmpty() ? 0 : mFragment.size;
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles?.get(position)
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    fun isEmpty(): Boolean{
        return mFragments == null
    }


}