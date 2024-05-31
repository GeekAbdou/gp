package com.example.readx.ui.screens.graduation_projects.gp_status

import com.example.booksaplicationkotlin.model.GradProject

data class GraduationProjectStatusUIState(

    val gradProject: GradProject? = null,
    val isLoading: Boolean = true,
    val status: GradProjectStatus = GradProjectStatus.NONE,
    var email: String = ""
)

enum class GradProjectStatus {
    SUCCESS,
    PENDING,
    REJECTED,
    NONE

}