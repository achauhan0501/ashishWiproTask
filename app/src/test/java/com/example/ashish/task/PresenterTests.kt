package com.example.ashish.task


import android.content.Context
import com.example.ashish.task.adapter.ItemsAdapter
import com.example.ashish.task.model.RowData
import com.example.ashish.task.view.MainActivity
import com.nhaarman.mockito_kotlin.spy
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class PresenterTests {


    @Mock
    private var list: ArrayList<RowData> = ArrayList()
    private var context: Context? = null
    //
    var mainActivity: MainActivity? = null


    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainActivity = MainActivity()
        context = mainActivity
        list = spy()
    }



    @Test
    fun testSmallTest() {
        assertNotNull("MainActivity is not available", mainActivity)
    }

    @Test
    fun testForAdapter() {
        val adapter = ItemsAdapter()
        assertNotNull("", adapter)
    }

    @Test
    fun checkListInAdapter() {
        val adapter = ItemsAdapter()
        assertNotNull("", adapter.list)
    }

    @Test
    fun checkTitle() {
        assertNotNull("", mainActivity!!.title)
    }


}