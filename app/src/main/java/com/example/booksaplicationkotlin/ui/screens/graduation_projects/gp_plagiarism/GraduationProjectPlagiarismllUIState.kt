package com.example.readx.ui.screens.graduation_projects.gp_plagiarism

data class GraduationProjectPlagiarismllUIState(
    val graduationProjects: List<GraduationProjectPlagiarismllUIState> = emptyList(),
    val graduationProjectName: String = "",
    val graduationProjectDescription: String = "",
    val year: String = "",
    val onBackClick: () -> Unit = {},
    val errorMessage: String = "error",
    val isLoading: Boolean = true,


    )
