package com.example.booksaplicationkotlin.ui.screens.graduation_projects.gp_details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.example.booksaplicationkotlin.model.GradProject
import com.example.readx.ui.Event
import com.example.readx.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GPDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<GPDetailsUIState, GPDetailsEvent>(GPDetailsUIState(), Event()) {
    init {
        val gpDetails: GradProject = checkNotNull(savedStateHandle[GRAD_PROJECT])
        Log.d("NONI", "gpDetails:$gpDetails ")
        _state.update { it.copy(gPDetails = gpDetails) }
    }

    companion object {
        const val GRAD_PROJECT = "gradProject"
    }
}