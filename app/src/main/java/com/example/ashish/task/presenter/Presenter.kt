package com.example.ashish.task.presenter

interface Presenter<V> {

    fun attachedView(view: V)

    fun detachView()

    fun onResume()

}