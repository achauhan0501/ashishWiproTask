package com.example.ashish.task.model

import android.os.Handler
import com.example.ashish.task.model.network.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InteractorImpl : Interactor {

    override fun loadItems(loaderListener: LoaderListener) {
        RestClient.getClient().getData().enqueue(object : Callback<ResponseData> {
            override fun onResponse(p0: Call<ResponseData>?, response: Response<ResponseData>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        Handler().postDelayed({ loaderListener.onFinished(responseBody.rows, responseBody.title) }, 1000)

                    }
                }
            }

            override fun onFailure(p0: Call<ResponseData>?, p1: Throwable?) {

            }
        })
    }
}