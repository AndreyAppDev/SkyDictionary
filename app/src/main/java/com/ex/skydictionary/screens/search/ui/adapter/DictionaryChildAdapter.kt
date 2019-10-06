package com.ex.skydictionary.screens.search.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.BaseViewHolder
import com.ex.skydictionary.internal.adapter.ListItemView
import com.ex.skydictionary.internal.extensions.capsFistChar
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO
import com.ex.skydictionary.screens.search.domain.entities.response.PartOfSpeech

class DictionaryChildAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList = mutableListOf<ListItemView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == BODY) {
            DictionaryChildViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.dictionary_child_body,
                    parent,
                    false
                )
            )
        } else {
            DictionaryChildHeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.dictionary_child_header,
                    parent,
                    false
                )
            )
        }
    }

    fun updateAll(data: List<ListItemView>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == HEADER && holder is DictionaryChildHeaderViewHolder) {
            holder.bind(dataList[position] as PartOfSpeech)
        } else if (holder is DictionaryChildViewHolder) {
            holder.bind(dataList[position] as MeaningDTO)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataList[position] is PartOfSpeech) {
            HEADER
        } else {
            BODY
        }
    }

    companion object {
        const val HEADER = 0
        const val BODY = 1
    }

}

class DictionaryChildHeaderViewHolder(view: View) : BaseViewHolder<PartOfSpeech>(view) {

    private val header: TextView by lazy { itemView.findViewById<TextView>(R.id.header) }

    override fun bind(data: PartOfSpeech) {
        header.text = data.text.capsFistChar()
    }

}

class DictionaryChildViewHolder(view: View) :
    BaseViewHolder<MeaningDTO>(view) {

    private val text: TextView by lazy { itemView.findViewById<TextView>(R.id.translation) }
    private val transcription: TextView by lazy { itemView.findViewById<TextView>(R.id.transcription) }

    override fun bind(data: MeaningDTO) {
        text.text = data.translation.text.capsFistChar()
        transcription.text = "[${data.transcription}]"
    }

}
