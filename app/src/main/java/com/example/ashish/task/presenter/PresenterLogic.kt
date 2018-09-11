package com.example.ashish.task.presenter

import android.content.Context
import android.widget.Toast
import com.example.ashish.task.R
import com.example.ashish.task.model.ResponseData
import com.example.ashish.task.network.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterLogic(var mGetDataView: GetDataInterface.View) :
        GetDataInterface.Presenter {


    override fun getDataFromURL(context: Context) {
        RestClient.getClient().getData().enqueue(object : Callback<ResponseData> {
            override fun onResponse(p0: Call<ResponseData>?, response: Response<ResponseData>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        mGetDataView.onGetDataSuccess("", responseBody.rows, responseBody.title)
                    } else {
                        Toast.makeText(context, context?.getString(R.string.no_data), Toast.LENGTH_LONG).show()

                    }

                }
            }

            override fun onFailure(p0: Call<ResponseData>?, p1: Throwable?) {
                mGetDataView.onGetDataFailure(p1?.message!!)

            }
        })

    }

}