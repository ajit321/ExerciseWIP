package com.wipro.exercise.ui.fragment


import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.wipro.exercise.R
import com.wipro.exercise.base.BaseVmFragment
import com.wipro.exercise.commn.onNetError
import com.wipro.exercise.model.bean.Row
import com.wipro.exercise.ui.adapter.HomePageAdapter
import com.wipro.exercise.utils.toast
import com.wipro.exercise.vm.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseVmFragment<HomeViewModel>() {
    private val mLayoutManager by lazy { LinearLayoutManager(context) }
    private val mArticleAdapter by lazy { HomePageAdapter(layoutInflater) }
    override fun providerVMClass(): Class<HomeViewModel>? = HomeViewModel::class.java

    private var toolbarTitle = MutableLiveData<String>()
    fun updateToolbarTitle(): MutableLiveData<String> {
        return toolbarTitle
    }
    override fun getLayoutResId(): Int =R.layout.fragment_home
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun initView(view: View) {
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

    override fun initData() {
    }
    private fun refresh() {
        getData()
    }
    private fun getData() {
        mViewModel.getHomePageJson {
            context!!.toast("error")
            homeRefreshLayout.isRefreshing = false
        }
    }

    override fun startObserve() {
        // super.startObserve()
        mViewModel.apply {
            homePageData.observe(this@HomeFragment, Observer { dataList -> updateData(dataList) })
            appTitle.observe(this@HomeFragment, Observer { title -> toolbarTitle.value=title })
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
        activity?.onNetError(e){
            Log.d(tag, "onError = " + e.message)
            homeRefreshLayout.isRefreshing = false
        }
    }

}
