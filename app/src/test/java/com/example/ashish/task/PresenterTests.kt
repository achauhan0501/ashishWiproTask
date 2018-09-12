package com.example.ashish.task


import android.content.Context
import android.support.v7.widget.RecyclerView
import com.example.ashish.task.adapter.ItemsAdapter
import com.example.ashish.task.model.ResponseData
import com.example.ashish.task.model.RowData
import com.example.ashish.task.network.ApiContract
import com.example.ashish.task.network.RestClient
import com.example.ashish.task.presenter.GetDataInterface
import com.example.ashish.task.presenter.PresenterLogic
import com.nhaarman.mockito_kotlin.spy
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import okhttp3.OkHttpClient








class PresenterTests {


    @Mock
    private var mockGetDataView: GetDataInterface.View ?=null
    private var view: GetDataInterface.View? = null
    private var presenter: PresenterLogic? = null
    private var mockmainActivity: MainActivity? = null
    private var mockAdapter: ItemsAdapter? = null
    private var list: ArrayList<RowData> = ArrayList()
    private var context: Context? = null
    private var recyclerView: RecyclerView? = null
    private var mockViewHolder: ItemsAdapter.ViewHolder? = null
    private var mockApiContract : ApiContract ?= null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mockmainActivity = MainActivity()
        context = mockmainActivity
        mockGetDataView = spy()
        presenter = PresenterLogic(mockGetDataView!!)

        list = spy()
    }

    @Test
    fun testGetView(){
        assertNotNull("GetDataView not null in presenter",mockGetDataView)
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