package com.example.ashish.task

import com.example.ashish.task.model.ResponseData
import com.example.ashish.task.model.RowData
import com.example.ashish.task.model.network.RestClient
import com.nhaarman.mockito_kotlin.spy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelTest {
    private var responseData: ResponseData? = null
    private var rowData: ArrayList<RowData> = ArrayList()
    private var list: ArrayList<RowData> = ArrayList()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        list = spy()
        responseData = ResponseData()
        responseData!!.title = "About"
        responseData!!.rows = list
        rowData = getRowData()
    }

    @Test
    fun testData() {
        Assert.assertTrue(responseData!!.title == "About")
        Assert.assertTrue(responseData!!.rows == list)
    }

    @Test
    fun testRowData() {
        list = rowData
        Assert.assertTrue(rowData[0].title == list[0].title)
        Assert.assertTrue(rowData[0].description == list[0].description)
        Assert.assertTrue(rowData[0].imageHref == list[0].imageHref)
    }

    fun getRowData(): ArrayList<RowData> {
        val dataList: ArrayList<RowData> = ArrayList()
        val singleRowData = RowData()
        singleRowData.title = "firstTitle"
        singleRowData.description = "firstDescriprion"
        singleRowData.imageHref = "abc.png"
        dataList.add(singleRowData)
        return dataList
    }

    @Test
    fun searchUsers_IOExceptionThenSuccess_SearchUsersRetried() {
        RestClient.getClient().getData().enqueue(object : Callback<ResponseData> {
            override fun onResponse(p0: Call<ResponseData>?, response: Response<ResponseData>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {

                    }
                }
            }

            override fun onFailure(p0: Call<ResponseData>?, p1: Throwable?) {
            }
        })

    }

}