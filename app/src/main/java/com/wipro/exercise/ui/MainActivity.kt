package com.wipro.exercise.ui

import androidx.lifecycle.Observer
import com.wipro.exercise.R
import com.wipro.exercise.base.BaseVMActivity
import com.wipro.exercise.ui.fragment.HomeFragment

class MainActivity : BaseVMActivity() {

    private val homeFragment = HomeFragment.newInstance()

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_layout, homeFragment, "HomeFragment")
            .addToBackStack(null)
            .commit()
    }

    override fun initData() {
        homeFragment.updateToolbarTitle().observe(this, Observer {
            setToolbarTitle(it)
        })
    }


}
