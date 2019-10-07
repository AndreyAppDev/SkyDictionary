package com.ex.skydictionary.screens.wordcard.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.BaseBottomSheetDialog
import com.ex.skydictionary.internal.viewmodel.getViewModel
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO
import com.ex.skydictionary.screens.wordcard.di.WordMeaningsInfoComponent
import com.ex.skydictionary.screens.wordcard.presentation.IWordDetailInfoViewModel
import com.ex.skydictionary.screens.wordcard.presentation.WordDetailInfoViewModel
import com.ex.skydictionary.screens.wordcard.ui.adapter.WordMeaningsDetailAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_word_card.*
import javax.inject.Inject

class WordCardBottomSheet : BaseBottomSheetDialog() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: IWordDetailInfoViewModel

    private val requestManager by lazy {
        Glide.with(this)
            .applyDefaultRequestOptions(
                RequestOptions()
            )
    }
    private val adapter by lazy { WordMeaningsDetailAdapter(requestManager) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        WordMeaningsInfoComponent.getComponent(this).inject(this)
        val view = inflater.inflate(R.layout.bottom_sheet_word_card, container, false)
        viewModel = getViewModel<WordDetailInfoViewModel>(viewModelFactory)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getParcelable<MeaningDTO>(MEANING_KEY)
        if (savedInstanceState == null && data != null) {
            viewModel.loadDetailInfo(data)
        }
        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        observeDataChanges()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<FrameLayout>(R.id.design_bottom_sheet)
                ?: return@setOnShowListener
            val bottomSheetBehavior = BottomSheetBehavior.from<FrameLayout>(bottomSheet)
            setDismissDialogOnBottomSheetCallback(bottomSheetBehavior)
        }

        return dialog
    }

    private fun initRecyclerView() {
        word_meaning_details_recycler_view.layoutManager = LinearLayoutManager(this.context)
        word_meaning_details_recycler_view.adapter = adapter
    }

    private fun observeDataChanges() {
        viewModel.onDetailLoadLiveData.observe(this, Observer { details ->
            word_detail_view.isVisible = true
            word.text = details.text
            details.transcription?.let { transcription ->
                word_transcription.text = transcription
            }
            details.translation?.let { translation ->
                word_translation.text = translation.text
            }
            word_definition_view.isVisible = true
            definition.text = details.definitions.text
            adapter.updateAll(details.wordMeaningDetails)
        })
    }

    companion object {
        private const val MEANING_KEY = "meaningKey"

        fun getInstance(data: MeaningDTO): BottomSheetDialogFragment =
            WordCardBottomSheet().apply {
                arguments = Bundle().apply {
                    putParcelable(MEANING_KEY, data)
                }
            }
    }

}
