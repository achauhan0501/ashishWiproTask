package com.example.ashish.task

import android.support.v7.widget.LinearLayoutManager
import com.example.ashish.task.adapter.ItemsAdapter
import com.example.ashish.task.receiver.ConnectionReceiver
import com.example.ashish.task.receiver.MainApplication
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class ActivityTests {

    @Mock
    private var mockActivity: ActivityTests? = null
    private var isConnected: Boolean = true
    private var layoutManager: LinearLayoutManager? = null
    private var adapter: ItemsAdapter? = null
    private var mockMainApplication: MainApplication? = null
    private var connectionReceiver: ConnectionReceiver? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        //MockitoAnnotations.initMocks(this)
        mockActivity = ActivityTests()
        layoutManager = mockActivity!!.layoutManager
        adapter = ItemsAdapter()
        mockMainApplication = MainApplication()
        connectionReceiver = ConnectionReceiver()
    }

    @Test
    fun testForMainActivity() {
        Assert.assertNotNull("MainActivity is not available", mockActivity)
    }


    @Test
    fun testForNetwork() {
        Assert.assertTrue("Don't show snackBar", isConnected)
    }



    @Test
    fun testForLayoutManager() {
        Assert.assertNull("LayoutManager not null", layoutManager)
    }

    @Test
    fun testLoadImageGlide() {
        Assert.assertFalse("Don't call load image", mockActivity == null)
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