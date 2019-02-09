package com.example.almondcafe.ui.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.almondcafe.R
import com.example.almondcafe.adapter.DashBoardPagerAdapter
import com.example.almondcafe.fragment.EditItems
import com.example.almondcafe.util.AppPreferences
import com.example.almondcafe.viewmodel.MainActivityVM
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainActivityVM: MainActivityVM
    var menuItem: MenuItem? = null
    @Inject
    lateinit var appPreferences: AppPreferences

    lateinit var dashBoardPagerAdapter: DashBoardPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        if (!appPreferences.isDataInserted){
            Toast.makeText(this,"Ran",Toast.LENGTH_LONG).show()
            insertDataToDatabase()
            appPreferences.isDataInserted=true
        }
        initializeBottomNavigationView()
    }

    private fun insertDataToDatabase() {
        mainActivityVM.insertAllData()
    }

    private fun initializeBottomNavigationView() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> view_pager.currentItem = 0
                R.id.navigation_dashboard -> view_pager.currentItem = 1
                R.id.navigation_notifications -> view_pager.currentItem = 2
                R.id.navigation_edit_items ->view_pager.currentItem=3
            }
            true
        }
        view_pager.offscreenPageLimit = 4

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (menuItem != null) {
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

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item!!.itemId) {
//            R.id.item_edit_item -> Toast.makeText(this, "Edit item clicked", Toast.LENGTH_SHORT).show()
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private fun setupViewPager() {
        dashBoardPagerAdapter = DashBoardPagerAdapter(supportFragmentManager, this)
        view_pager.adapter = dashBoardPagerAdapter
    }
}
