package com.example.readx.ui.screens.graduation_projects.gp_status

sealed class GraduationProjectStatusNavigationEvent {
    object NavigateBack : GraduationProjectStatusNavigationEvent()
    data class NavigateToHome(val userId: Int) : GraduationProjectStatusNavigationEvent()

}