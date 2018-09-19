package com.example.ashish.task.presenter

import com.example.ashish.task.model.RowData
import java.util.*

interface GetDataInterface {

    // View interface.
    interface View {
        fun onGetDataSuccess(message: String, list: ArrayList<RowData>, title: String)
        fun onGetDataFailure(message: String)
    }

    interface Presenter {
        fun getDataFromURL()
    }

    interface GetData {
        fun initRetrofitCall()

    }

    interface onGetDataListener {
        fun onSuccess(message: String, list: ArrayList<RowData>, titls: String)
        fun onFailure(message: String)
    }
}