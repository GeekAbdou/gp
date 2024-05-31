package com.example.readx.ui.screens.graduation_projects.projects_viewall

import com.example.booksaplicationkotlin.model.GPData
import com.example.booksaplicationkotlin.model.GradProject

data class GraduationProjectsViewallUIState(
    val graduationProjects: List<GradProject> = emptyList(),
    val graduationProjectName: String = "",
    val graduationProjectDescription: String = "",
    val year: String = "",
    val onBackClick: () -> Unit = {},
//    val onProjectClick: (GradProject) -> Unit = {},
    val errorMessage: String = "error",
    val isLoading: Boolean = true,


    )
