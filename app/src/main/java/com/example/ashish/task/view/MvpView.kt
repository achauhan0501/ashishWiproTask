package com.example.ashish.task.view

import com.example.ashish.task.model.RowData
import java.util.*

interface MvpView {
    fun setItems(list: ArrayList<RowData>, heading: String)

    fun showProgress()

    fun hideProgress()


}