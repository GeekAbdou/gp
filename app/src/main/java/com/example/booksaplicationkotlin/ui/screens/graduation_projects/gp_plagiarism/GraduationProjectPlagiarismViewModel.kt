package com.example.readx.ui.screens.graduation_projects.gp_plagiarism

import com.example.readx.ui.Event
import com.example.readx.ui.base.BaseViewModel
import com.example.readx.ui.screens.graduation_projects.GraduationProjectsNavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GraduationProjectPlagiarismViewModel @Inject constructor(
) : BaseViewModel<GraduationProjectPlagiarismllUIState, GraduationProjectPlagiarismNavigationEvent>(
    GraduationProjectPlagiarismllUIState(),
    Event()
) {


}

