package com.example.readx.ui.screens.graduation_projects.graduation_project_details

sealed class GraduationProjectDetailsNavigationEvent {
    object NavigateBack: GraduationProjectDetailsNavigationEvent()
    data class NavigateToHome(val userId: Int) : GraduationProjectDetailsNavigationEvent()

}