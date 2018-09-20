package com.example.ashish.task.presenter

import com.example.ashish.task.model.ApiCall
import com.example.ashish.task.model.RowData
import java.util.*

class PresenterLogic(var mGetDataView: GetDataInterface.View) :
        GetDataInterface.Presenter, GetDataInterface.onGetDataListener {


    var getData: ApiCall = ApiCall(this)


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