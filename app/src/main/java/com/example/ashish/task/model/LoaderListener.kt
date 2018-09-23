package com.example.ashish.task.model

import java.util.*

interface LoaderListener {
    fun onFinished(list: ArrayList<RowData>, heading: String)
}