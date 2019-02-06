package com.example.almondcafe.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.almondcafe.fragment.Past
import com.example.almondcafe.fragment.Today

class DashBoardPagerAdapter(manager: FragmentManager, context: Context) : FragmentPagerAdapter(manager) {
    val context: Context = context

    override fun getItem(position: Int): Fragment {
        when (position) {
            0-> return Today.newInstance()
            1 -> return Past.newInstance()
            2-> return Summary.newInstance()
//            PAST_POSITION -> return PastFragment.newInstance()
//            SUPPLIERS_POSITION -> return SuppliersFragment.newInstance()
        }
//        return TodayAuditFragment.newInstance()
        return Fragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {

        when (position) {
            0 -> return "Notice"
            1 -> return "Bus"
            2 -> return "Messages"
//            UPCOMING_POSITION -> context.getString(R.string.upcoming)
//            PAST_POSITION -> context.getString(R.string.past)
//            SUPPLIERS_POSITION -> context.getString(R.string.suppliers)
        }
        return null
    }

    override fun getCount(): Int {
        return 3
    }


}