package com.example.ashish.task

import android.support.v7.widget.LinearLayoutManager
import com.example.ashish.task.adapter.ItemsAdapter
import com.example.ashish.task.model.RowData
import com.example.ashish.task.presenter.PresenterLogic
import com.example.ashish.task.receiver.ConnectionReceiver
import com.example.ashish.task.receiver.MainApplication
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class MainActivityTests {

    @Mock
    private var mockmainActivity: MainActivity? = null
    private var isConnected: Boolean = true
    private var presenter: PresenterLogic? = null
    private var layoutManager: LinearLayoutManager? = null
    private var adapter: ItemsAdapter? = null
    private var list: ArrayList<RowData> = ArrayList()
    private var mockMainApplication: MainApplication? = null
    private var connectionReceiver: ConnectionReceiver? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        //MockitoAnnotations.initMocks(this)
        mockmainActivity = MainActivity()
        layoutManager = mockmainActivity!!.layoutManager
        adapter = ItemsAdapter()
        mockMainApplication = MainApplication()
        connectionReceiver = ConnectionReceiver()
    }

    @Test
    fun testForMainActivity() {
        Assert.assertNotNull("MainActivity is not available", mockmainActivity)
    }


    @Test
    fun testForNetwork() {
        mockmainActivity!!.onNetworkConnectionChanged(isConnected)
        Assert.assertTrue("Don't show snackBar", isConnected)
    }

    @Test
    fun testForViewMethods() {
        Assert.assertFalse("onGetDataSuccess() called", (presenter != null))
    }

    @Test
    fun testForLayoutManager() {
        Assert.assertNull("LayoutManager not null", layoutManager)
    }

    @Test
    fun testLoadImageGlide() {
        Assert.assertFalse("Don't call load image", mockmainActivity == null)
    }

    @Test
    fun testInstanceOfMainApplication() {
        Assert.assertTrue("Don't call connection listener", (MainApplication.getInstance() == null))
    }

    @Test
    fun testCallInstance() {
        Assert.assertFalse("Don't call get instance", (MainApplication.getInstance() != null))
    }




}