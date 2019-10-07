package com.ex.skydictionary.internal.adapter

import android.view.View
import android.view.ViewGroup
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

abstract class MultipleViewTypeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val dataList = mutableListOf<ListItemView>()
    private val viewHolderDelegates =
        mutableListOf<ViewHolderDelegate<*, *>>()
    private val viewTypes = mutableMapOf<Class<*>, Int>()
    private var viewTypeCounter = 0

    fun <Data> addDelegate(clazz: Class<Data>, viewHolderDelegate: ViewHolderDelegate<*, *>) {
        val counterNewVal = viewTypeCounter++
        viewHolderDelegates.add(viewHolderDelegate)
        viewTypes[clazz] = counterNewVal
    }

    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_STUB) EmptyStub.getInstance().createViewHolder(parent) else
            viewHolderDelegates[viewType].createViewHolder(parent)
    }

    override fun getItemViewType(position: Int): Int {
        return viewTypes[getItem(position).javaClass] ?: VIEW_TYPE_STUB
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)
        if (holder is BaseViewHolder<*>) {
            if (getItemViewType(position) != VIEW_TYPE_STUB)
                (viewHolderDelegates[getItemViewType(position)] as ViewHolderDelegate<Any, BaseViewHolder<*>>)
                    .bind(holder, data)
        }
    }

    fun getItem(pos: Int) = dataList[pos]

    fun updateAll(data: List<ListItemView>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    companion object {
        private const val VIEW_TYPE_STUB = -1
    }
}


abstract class ViewHolderDelegate<Data, ViewHolder : BaseViewHolder<*>> {

    abstract fun createViewHolder(parent: ViewGroup): ViewHolder

    abstract fun bind(viewHolder: ViewHolder, data: Data)

}

class EmptyStub : ViewHolderDelegate<Any, EmptyViewHolder>() {

    override fun bind(viewHolder: EmptyViewHolder, data: Any) {
        viewHolder.bind(data)
    }

    override fun createViewHolder(parent: ViewGroup): EmptyViewHolder {
        return EmptyViewHolder(parent)
    }

    companion object {
        fun getInstance(): EmptyStub = EmptyStub()
    }

}

abstract class BaseViewHolder<Data>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(data: Data)

}

class EmptyViewHolder(view: View) : BaseViewHolder<Any>(View(view.context)) {

    override fun bind(data: Any) {
    }
}

