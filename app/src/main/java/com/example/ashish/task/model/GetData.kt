package com.example.ashish.task.model

import com.example.ashish.task.network.RestClient
import com.example.ashish.task.presenter.GetDataInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetData(var listener: GetDataInterface.onGetDataListener) : GetDataInterface.GetData {


    override fun initRetrofitCall() {
        RestClient.getClient().getData().enqueue(object : Callback<ResponseData> {
            override fun onResponse(p0: Call<ResponseData>?, response: Response<ResponseData>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        listener.onSuccess("", responseBody.rows, responseBody.title)
                    }
                }
            }

            override fun onFailure(p0: Call<ResponseData>?, p1: Throwable?) {
                listener.onFailure(p1?.message!!)

            }
        })
    }
}