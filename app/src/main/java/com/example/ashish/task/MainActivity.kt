package com.example.ashish.task

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.ashish.task.adapter.ItemsAdapter
import com.example.ashish.task.model.RowData
import com.example.ashish.task.presenter.GetDataInterface
import com.example.ashish.task.presenter.PresenterLogic
import com.example.ashish.task.receiver.ConnectionReceiver
import com.example.ashish.task.receiver.MainApplication
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), GetDataInterface.View,
        ConnectionReceiver.ConnectionReceiverListener {


    var presenter: PresenterLogic? = null
    var layoutManager: LinearLayoutManager? = null
    var list: ArrayList<RowData> = ArrayList()
    var title: String = ""
    var snackbar: Snackbar? = null
    var mConnectionReceiver: BroadcastReceiver? = null
    var itemsAdapter: ItemsAdapter? = null
    val HEADING_SIZE: Float = 20f
    val LIST_STATE_KEY: String = "key"
    var listState: Parcelable? = null


    override fun onGetDataSuccess(message: String, data: java.util.ArrayList<RowData>, heading: String) {
        list = data
        title = heading
        swipe_layout.isRefreshing = false
        initialise()

    }

    override fun onGetDataFailure(message: String) {
        Toast.makeText(this@MainActivity, getString(R.string.no_internet_results), Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = ArrayList()
        presenter = PresenterLogic(this@MainActivity)
        layoutManager = LinearLayoutManager(this)
        itemsAdapter = ItemsAdapter()
        mConnectionReceiver = ConnectionReceiver()
        registerReceiver()
        swipe_layout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            if (ConnectionReceiver.isConnected()) {
                refresh()
            } else {
                swipe_layout.isRefreshing = false
                swipe_layout.isEnabled = false
            }
        })

        // Check for previous state.
        if (savedInstanceState != null) {
            restorePreviousState(savedInstanceState)
        } else {
            checkConnection()
        }

    }

    fun restorePreviousState(savedInstanceState: Bundle) {
        list = savedInstanceState.getParcelableArrayList(AppConstants.SAVED_RECYCLER_VIEW_DATASET)
        title = savedInstanceState.getString(AppConstants.SAVED_RECYCLER_VIEW_HEADING)
        if (listState != null) {
            layoutManager?.onRestoreInstanceState(listState)
        }
        initialise()
    }

    fun refresh() {
        list.clear()
        initialise()
        presenter?.getDataFromURL()
    }


    fun initialise() {
        rv.layoutManager = layoutManager
        rv.recycledViewPool.setMaxRecycledViews(0, 0)
        rv.setHasFixedSize(true)
        itemsAdapter?.addItems(list)
        rv.adapter = itemsAdapter
        val tv = TextView(applicationContext)
        // Create a LayoutParams for TextView
        val lp = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        tv.layoutParams = lp
        tv.gravity = Gravity.CENTER_HORIZONTAL
        tv.textSize = HEADING_SIZE
        tv.text = title
        top_view.addView(tv)

    }

    /**
     * Show No Internet Snackbar
     */
    fun showNoInternetSnackBar() {
        snackbar = Snackbar.make(ll_parent, getString(R.string.no_internet_results), Snackbar.LENGTH_INDEFINITE)
        snackbar?.setAction("RETRY", View.OnClickListener {
            if (ConnectionReceiver.isConnected()) {
                snackbar?.dismiss()
                presenter?.getDataFromURL()

            } else {
                showNoInternetSnackBar()
            }
        })
        snackbar?.duration = Snackbar.LENGTH_INDEFINITE
        snackbar?.setActionTextColor(Color.WHITE)
        val sbView = snackbar?.view
        val textView = sbView?.findViewById(android.support.design.R.id.snackbar_text) as TextView
        snackbar?.show()
    }

    /*
        *  Internet check
        * */
    private fun checkConnection() {
        val isConnected = ConnectionReceiver.isConnected()
        if (!isConnected)
            showNoInternetSnackBar()
        else
            presenter?.getDataFromURL()
    }


    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (!isConnected)
            showNoInternetSnackBar()
        else {
            snackbar?.dismiss()
            swipe_layout.isEnabled = true
        }
    }

    fun registerReceiver() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            registerReceiver(mConnectionReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    fun unRegisterReceiver() = try {
        unregisterReceiver(mConnectionReceiver)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelable(LIST_STATE_KEY, layoutManager?.onSaveInstanceState())
        outState?.putParcelableArrayList(AppConstants.SAVED_RECYCLER_VIEW_DATASET, list)
        outState?.putString(AppConstants.SAVED_RECYCLER_VIEW_HEADING, title)
        super.onSaveInstanceState(outState)
    }

    override fun onResume() {
        MainApplication.getInstance().setConnectionListener(this)
        super.onResume()
    }


    override fun onDestroy() {
        unRegisterReceiver()
        super.onDestroy()
    }


}
