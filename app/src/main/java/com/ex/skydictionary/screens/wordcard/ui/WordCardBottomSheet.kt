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
import com.ex.skydictionary.R
import com.ex.skydictionary.internal.viewmodel.getViewModel
import com.ex.skydictionary.screens.search.domain.entities.response.MeaningDTO
import com.ex.skydictionary.screens.wordcard.di.WordMeaningsInfoComponent
import com.ex.skydictionary.screens.wordcard.presentation.IWordDetailInfoViewModel
import com.ex.skydictionary.screens.wordcard.presentation.WordDetailInfoViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_word_card.*
import javax.inject.Inject

class WordCardBottomSheet : BottomSheetDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: IWordDetailInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        WordMeaningsInfoComponent.getComponent(this).inject(this)
        val view = inflater.inflate(R.layout.bottom_sheet_word_card, container, false)
        viewModel = getViewModel<WordDetailInfoViewModel>(viewModelFactory)
        val data = arguments?.getParcelable<MeaningDTO>(MEANING_KEY)

        if (savedInstanceState == null && data != null) {
            viewModel.loadDetailInfo(data)
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        observeDataChanges()
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
        })
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<FrameLayout>(R.id.design_bottom_sheet)
                ?: return@setOnShowListener
            val bottomSheetBehavior = BottomSheetBehavior.from<FrameLayout>(bottomSheet)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        return dialog
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
