package com.example.readx.ui.screens.graduation_projects.gp_plagiarism

sealed class GraduationProjectPlagiarismNavigationEvent {
    object NavigateBack: GraduationProjectPlagiarismNavigationEvent()
    data class NavigateToHome(val userId: Int) : GraduationProjectPlagiarismNavigationEvent()

}