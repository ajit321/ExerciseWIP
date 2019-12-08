package com.wipro.exercise.ui

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.wipro.exercise.R
import com.wipro.exercise.base.BaseVMActivity
import com.wipro.exercise.commn.onNetError
import com.wipro.exercise.model.bean.Row
import com.wipro.exercise.ui.adapter.HomePageAdapter
import com.wipro.exercise.utils.toast
import com.wipro.exercise.vm.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVMActivity<HomeViewModel>()  {
    private val mLayoutManager by lazy { LinearLayoutManager(this) }
    private val mArticleAdapter by lazy { HomePageAdapter(layoutInflater) }
    override fun providerVMClass(): Class<HomeViewModel>? = HomeViewModel::class.java
    private val TAG = MainActivity::class.java.simpleName

    override fun getLayoutResId(): Int =R.layout.activity_main

    override fun initView() {
        mRecyclerView.run {
            layoutManager = mLayoutManager
            adapter = mArticleAdapter
        }
        homeRefreshLayout.run {
            isRefreshing = true
            setOnRefreshListener { refresh() }
        }
        getData()
    }
    private fun refresh() {
        getData()
    }

    private fun getData() {
        mViewModel.getHomePageJson {
           toast("error")
            homeRefreshLayout.isRefreshing = false
        }
    }

    override fun initData() {
    }
    override fun startObserve() {
        // super.startObserve()
        mViewModel.apply {
            homePageData.observe(this@MainActivity, Observer { dataList -> updateData(dataList) })
            appTitle.observe(this@MainActivity, Observer { title -> setToolbarTitle(title) })
        }

    }

    private fun updateData(dataList: List<Row>?) {
        mArticleAdapter.setData(dataList!!.filter {
            row ->  row.title!=null
        } as ArrayList<Row>)
        homeRefreshLayout.isRefreshing = false

    }

    override fun onError(e: Throwable) {
        super.onError(e)
        onNetError(e){
            Log.d(TAG, "onError = " + e.message)
            homeRefreshLayout.isRefreshing = false
        }
    }
}
