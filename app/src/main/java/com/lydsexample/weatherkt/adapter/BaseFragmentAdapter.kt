package com.lydsexample.weatherkt.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

abstract class BaseFragmentAdapter(fm: FragmentManager?, fragmentList: List<Fragment>, titles: List<String>) : FragmentStatePagerAdapter(fm) {
    var titles: List<String>? = null
    var mFragments: ArrayList<Fragment> = ArrayList()

    init {
        mFragments.addAll(fragmentList)
        this.titles = titles;
    }

    override fun getItem(position: Int): Fragment {
        return mFragments.get(position)
    }

    override fun getCount(): Int {
        return mFragments.size;
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles?.get(position)
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

}