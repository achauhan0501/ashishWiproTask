package com.example.ashish.task.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ashish.task.R
import com.example.ashish.task.databinding.RowItemBinding
import com.example.ashish.task.model.RowData
import com.squareup.picasso.Picasso


class ItemsAdapter(var context: Context, var list: ArrayList<RowData>) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapter.ViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        return ViewHolder(DataBindingUtil.inflate(layoutInflator, R.layout.row_item, parent, false))
    }


    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ItemsAdapter.ViewHolder, position: Int) {
        val itemHolder = holder
        val rowData = list[position]

        itemHolder.binding.tvTitle.text = rowData.title
        itemHolder.binding.tvHeading.text = rowData.description

        Picasso.get()
                .load(rowData.imageHref)
                .placeholder(R.drawable.pattern_placeholder)
                .error(R.drawable.pattern_placeholder)
                .into(itemHolder.binding.ivMain)

    }

    inner class ViewHolder(var binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

}