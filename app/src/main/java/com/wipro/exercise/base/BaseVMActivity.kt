package com.wipro.exercise.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleObserver
import com.wipro.exercise.R

abstract class BaseVMActivity : AppCompatActivity(), LifecycleObserver {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initView()
        initData()
    }
    protected fun setToolbarTitle(title: String) {
        val mToolbar = findViewById<Toolbar>(R.id.toolbar)
        mToolbar.title = title
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        setSupportActionBar(mToolbar)
    }
    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()


}