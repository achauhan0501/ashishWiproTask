package com.example.ashish.task


import android.content.Context
import android.support.v7.widget.RecyclerView
import com.example.ashish.task.adapter.ItemsAdapter
import com.example.ashish.task.model.RowData
import com.example.ashish.task.presenter.GetDataInterface
import com.example.ashish.task.presenter.PresenterLogic
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class PresenterTests {



    @Mock
    private var view: GetDataInterface.View? = null
    private var presenter: PresenterLogic? = null
    private var mockmainActivity: MainActivity? = null
    private var mockAdapter: ItemsAdapter? = null
    private var list: ArrayList<RowData> = ArrayList()
    private var context: Context? = null
    private var recyclerView: RecyclerView? = null
    private var mockViewHolder: ItemsAdapter.ViewHolder? = null


    @Test
    fun testSmallTest() {
        val activity = MainActivity()
        assertNotNull("MainActivity is not available", activity)
    }

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        context = mockmainActivity
        // Make presenter a mock while using mock repository and viewContract created above
        presenter = Mockito.spy<PresenterLogic>(PresenterLogic(this.view!!))
        mockmainActivity = MainActivity()
        mockAdapter = ItemsAdapter(context!!, list)
    }

    @Test
    fun testForAdapterItems() {
        val rowData = ArrayList<RowData>()
        Mockito.`when`(mockAdapter!!.itemCount).thenReturn(rowData.size)

    }



    @Test
    fun defaultDisplay() {
        val recyclerView = mockmainActivity!!.findViewById(R.id.rv) as RecyclerView
        val layoutManager = recyclerView.layoutManager
        Mockito.verify(layoutManager)
    }


}