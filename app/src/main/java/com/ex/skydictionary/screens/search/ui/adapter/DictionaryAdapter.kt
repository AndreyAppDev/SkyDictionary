package com.ex.skydictionary.screens.search.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.BaseAdapter
import com.ex.skydictionary.internal.adapter.BaseViewHolder
import com.ex.skydictionary.internal.extensions.capsFistChar
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO
import com.ex.skydictionary.screens.search.domain.entities.response.SearchInDirectoryDTO

class DictionaryAdapter(
    private val onItemBodyClickListener: (MeaningDTO) -> Unit
) : BaseAdapter<SearchInDirectoryDTO, DictionaryViewHolder>() {

    private val recyclerViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryViewHolder {
        return DictionaryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dictionary_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val childLayoutManager = LinearLayoutManager(holder.recyclerView.context)
        val data = dataList[position]
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            val dictionaryChildAdapter = DictionaryChildAdapter(onItemBodyClickListener)
            adapter = dictionaryChildAdapter
            dictionaryChildAdapter.updateAll(data.gropedMeanings)
            setRecycledViewPool(recyclerViewPool)
        }
    }

}

class DictionaryViewHolder(view: View) : BaseViewHolder<SearchInDirectoryDTO>(view) {

    private val text: TextView by lazy { itemView.findViewById<TextView>(R.id.text) }
    internal val recyclerView: RecyclerView by lazy { itemView.findViewById<RecyclerView>(R.id.nested_recycler) }

    override fun bind(data: SearchInDirectoryDTO) {
        text.text = data.text.capsFistChar()
    }

}
