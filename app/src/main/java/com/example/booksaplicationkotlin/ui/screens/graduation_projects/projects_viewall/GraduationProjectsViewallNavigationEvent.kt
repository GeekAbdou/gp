package com.example.readx.ui.screens.graduation_projects.projects_viewall

import com.example.booksaplicationkotlin.model.GradProject

sealed class GraduationProjectsViewallNavigationEvent {
//    object NavigateBack: GraduationProjectsViewallNavigationEvent()
//    data class NavigateToHome(val userId: Int) : GraduationProjectsViewallNavigationEvent()
    data class NavigateToProject(val gradProject: GradProject) : GraduationProjectsViewallNavigationEvent()

}