package com.ex.skydictionary.screens.wordcard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.adapter.BaseViewHolder
import com.ex.skydictionary.internal.adapter.SectionHeaderItemView
import com.ex.skydictionary.internal.adapter.ViewHolderDelegate

class SectionHeaderViewHolderDelegate :
    ViewHolderDelegate<SectionHeaderItemView, SectionHeaderViewHolder>() {

    override fun createViewHolder(parent: ViewGroup): SectionHeaderViewHolder {
        return SectionHeaderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.section_header_item, parent, false)
        )
    }

    override fun bind(viewHolder: SectionHeaderViewHolder, data: SectionHeaderItemView) {
        viewHolder.bind(data)
    }

}

class SectionHeaderViewHolder(view: View) : BaseViewHolder<SectionHeaderItemView>(view) {

    private val header: TextView by lazy { view.findViewById<TextView>(R.id.word_meaning_details_header) }

    override fun bind(data: SectionHeaderItemView) {
        header.text = data.text
    }
}