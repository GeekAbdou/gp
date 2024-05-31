package com.example.readx.ui.screens.graduation_projects

import com.example.readx.ui.Event
import com.example.readx.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GraduationProjectsViewModel @Inject constructor(
) : BaseViewModel<GraduationProjectsUIState, GraduationProjectsNavigationEvent>(
    GraduationProjectsUIState(),
    Event()
) {


}

