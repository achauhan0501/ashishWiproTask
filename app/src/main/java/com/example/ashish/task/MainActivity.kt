package com.example.ashish.task

import android.graphics.Color
import android.os.Bundle
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

    override fun onGetDataSuccess(message: String, data: java.util.ArrayList<RowData>, heading: String) {
        list = data
        title = heading
        initialise()
        swipe_layout.isRefreshing = false
    }

    override fun onGetDataFailure(message: String) {
        Toast.makeText(this@MainActivity, getString(R.string.no_internet_results), Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PresenterLogic(this@MainActivity)
        checkConnection()
        layoutManager = LinearLayoutManager(this)
        list = ArrayList()



        swipe_layout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            if (ConnectionReceiver.isConnected()) {
                swipe_layout.isEnabled = true
                refresh()
                swipe_layout.isRefreshing = false
            } else {
                swipe_layout.isRefreshing = false
                swipe_layout.isEnabled = false
            }
        })

    }

    override fun onResume() {
        super.onResume()
        MainApplication.getInstance().setConnectionListener(this)
    }

    fun refresh() {
        list.clear()
        initialise()
        presenter?.getDataFromURL(this@MainActivity)
    }


    fun initialise() {
        rv.adapter = ItemsAdapter(this, list)
        rv.layoutManager = layoutManager
        val tv = TextView(applicationContext)
        // Create a LayoutParams for TextView
        val lp = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, // Width of TextView
                ViewGroup.LayoutParams.WRAP_CONTENT) // Height of TextView
        // Apply the layout parameters to TextView widget
        tv.layoutParams = lp
        tv.gravity = Gravity.CENTER_HORIZONTAL
        tv.textSize = 20f
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
                presenter?.getDataFromURL(this@MainActivity)

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
        if (!isConnected) {
            showNoInternetSnackBar()
        } else {
            presenter?.getDataFromURL(this@MainActivity)
        }
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (!isConnected) {
            //show a No Internet Alert or Dialog
            showNoInternetSnackBar()
        } else {
            // dismiss the dialog or refresh the activity
            snackbar?.dismiss()
        }
    }


}
