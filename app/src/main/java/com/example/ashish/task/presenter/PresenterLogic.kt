package com.example.ashish.task.presenter

import com.example.ashish.task.model.GetData
import com.example.ashish.task.model.RowData
import java.util.*

class PresenterLogic(var mGetDataView: GetDataInterface.View) :
        GetDataInterface.Presenter, GetDataInterface.onGetDataListener {


    var getData: GetData = GetData(this)


    override fun getDataFromURL() {
        getData.initRetrofitCall()
    }

    override fun onSuccess(message: String, list: ArrayList<RowData>, title: String) {
        mGetDataView.onGetDataSuccess(message, list, title)
    }

    override fun onFailure(message: String) {
        mGetDataView.onGetDataFailure(message)
    }

}