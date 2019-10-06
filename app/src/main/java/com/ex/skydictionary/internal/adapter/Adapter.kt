package com.ex.skydictionary.internal.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<Data, ViewHolder : BaseViewHolder<Data>> :
    RecyclerView.Adapter<ViewHolder>() {

    protected val dataList: MutableList<Data> = mutableListOf()

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    fun updateAll(data: List<Data>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

}

abstract class BaseViewHolder<Data>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(data: Data)

}
