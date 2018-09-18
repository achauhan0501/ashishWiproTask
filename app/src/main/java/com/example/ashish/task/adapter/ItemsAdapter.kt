package com.example.ashish.task.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ashish.task.R
import com.example.ashish.task.databinding.RowItemBinding
import com.example.ashish.task.model.RowData
import com.squareup.picasso.Picasso
import java.lang.Exception


class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    var list: ArrayList<RowData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapter.ViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        return ViewHolder(DataBindingUtil.inflate(layoutInflator, R.layout.row_item, parent, false))
    }


    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ItemsAdapter.ViewHolder, position: Int) {
        val itemHolder = holder

        itemHolder.binding.tvTitle.text = list[position].title
        itemHolder.binding.tvHeading.text = list[position].description

        itemHolder.binding.ivMain.visibility = View.VISIBLE
        Picasso.get()
                .load(list[position].imageHref)
                .error(R.drawable.pattern_placeholder)
                .noFade()
                .into(itemHolder.binding.ivMain, object : com.squareup.picasso.Callback {
                    override fun onError(e: Exception?) {
                        itemHolder.binding.ivMain.visibility = View.INVISIBLE
                    }

                    override fun onSuccess() {
                        //Success image already loaded into the view
                    }
                })

    }

    fun clearItems() {
        list.clear()
        notifyDataSetChanged()
    }

    fun addItems(data: ArrayList<RowData>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }


    inner class ViewHolder(var binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)


}