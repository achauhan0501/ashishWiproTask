package com.example.ashish.task


import android.content.Context
import android.support.v7.widget.RecyclerView
import com.example.ashish.task.adapter.ItemsAdapter
import com.example.ashish.task.model.RowData
import com.example.ashish.task.presenter.GetDataInterface
import com.example.ashish.task.presenter.PresenterLogic
import com.nhaarman.mockito_kotlin.spy
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations


class PresenterTests {


    //@Mock
    private var view: GetDataInterface.View? = null
    private var presenter: PresenterLogic? = null
    private var mockmainActivity: MainActivity? = null
    private var mockAdapter: ItemsAdapter? = null
    private var list: ArrayList<RowData> = ArrayList()
    private var context: Context? = null
    private var recyclerView: RecyclerView? = null
    private var mockViewHolder: ItemsAdapter.ViewHolder? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockmainActivity = MainActivity()
        context = mockmainActivity
        list = spy()
    }


    @Test
    fun testSmallTest() {
        assertNotNull("MainActivity is not available", mockmainActivity)
    }

    @Test
    fun testForAdapter() {
        val adapter = ItemsAdapter(context!!, list)
        assertNotNull("", adapter)
    }

    @Test
    fun checkListInAdapter() {
        val adapter = ItemsAdapter(context!!, list)
        assertNotNull("", adapter.list)
    }

    @Test
    fun checkTitle() {
        assertNotNull("", mockmainActivity!!.title)
    }


}