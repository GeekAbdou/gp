package com.example.readx.ui.screens.graduation_projects

sealed class GraduationProjectsNavigationEvent {
    object NavigateBack : GraduationProjectsNavigationEvent()
    data class NavigateToHome(val userId: Int) : GraduationProjectsNavigationEvent()

}