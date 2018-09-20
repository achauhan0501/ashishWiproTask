package com.example.ashish.task

import com.example.ashish.task.model.RowData

class AppConstants {

    companion object {
        val BASE_URL : String = "https://dl.dropboxusercontent.com/"
        val SAVED_RECYCLER_VIEW_DATASET : String = "list"
        val SAVED_RECYCLER_VIEW_HEADING : String = "title"
        val ROW_LIST = "row"
        var rowList : ArrayList<RowData> = ArrayList()
        var toolBarTitle : String = ""
    }
}