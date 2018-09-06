package com.example.ashish.task.network

import com.example.ashish.task.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface ApiContract {
    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getData(): Call<ResponseData>
}