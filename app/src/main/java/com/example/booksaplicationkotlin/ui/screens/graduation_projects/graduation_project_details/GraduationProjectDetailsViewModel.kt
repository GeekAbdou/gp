package com.example.readx.ui.screens.graduation_projects.graduation_project_details

import com.example.readx.ui.Event
import com.example.readx.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GraduationProjectDetailsViewModel @Inject constructor(
) : BaseViewModel<GraduationProjectDetailsUIState, GraduationProjectDetailsNavigationEvent>(
    GraduationProjectDetailsUIState(),
    Event()
) {

}