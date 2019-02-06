package com.example.almondcafe.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.MenuItem
import com.example.almondcafe.R
import com.example.almondcafe.adapter.DashBoardPagerAdapter
import com.example.almondcafe.viewmodel.MainActivityVM
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainActivityVM: MainActivityVM
    var menuItem: MenuItem? = null
    lateinit var dashBoardPagerAdapter: DashBoardPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        initializeBottomNavigationView()
    }

    private fun initializeBottomNavigationView() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> view_pager.currentItem = 0
                R.id.navigation_dashboard -> view_pager.currentItem = 1
                R.id.navigation_notifications -> view_pager.currentItem = 2
            }
            true
        }
        view_pager.offscreenPageLimit = 3

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (menuItem != null)  {
                    menuItem!!.isChecked = false;
                } else {
                    bottom_navigation.menu.getItem(0).isChecked = false
                }
                Log.d("page", "onPageSelected: " + position);
                bottom_navigation.menu.getItem(position).setChecked(true)
                menuItem = bottom_navigation.menu.getItem(position)
            }
        })
        setupViewPager()
    }

    private fun setupViewPager() {
        dashBoardPagerAdapter = DashBoardPagerAdapter(supportFragmentManager, this)
        view_pager.adapter = dashBoardPagerAdapter
    }
}
