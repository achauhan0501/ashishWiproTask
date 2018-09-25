package com.example.ashish.task.model

import android.os.Handler
import com.example.ashish.task.model.network.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InteractorImpl : Interactor {

    var arrayList: ArrayList<RowData> = ArrayList()
    var title: String = ""

    override fun loadItems(loaderListener: LoaderListener) {
        RestClient.getClient().getData().enqueue(object : Callback<ResponseData> {
            override fun onResponse(p0: Call<ResponseData>?, response: Response<ResponseData>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        Handler().postDelayed({ loaderListener.onFinished(responseBody.rows, responseBody.title) }, 1000)
                        DataConstants.row_list.clear()
                        DataConstants.title = ""
                        DataConstants.row_list = responseBody.rows
                        DataConstants.title = responseBody.title
                    }
                }
            }

            override fun onFailure(p0: Call<ResponseData>?, p1: Throwable?) {

            }
        })
    }

}