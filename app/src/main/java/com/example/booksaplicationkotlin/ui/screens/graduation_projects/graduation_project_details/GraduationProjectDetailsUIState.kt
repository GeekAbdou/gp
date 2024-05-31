package com.example.readx.ui.screens.graduation_projects.graduation_project_details

data class GraduationProjectDetailsUIState(
    val item: Item?=null,
    val isLoading: Boolean = true,
)

data class Item(
    val graduationProjectName: String = "",
    val graduationProjectDescription: String = "",
    val year: String = "",
    val authorName: String = "",
    val professorName: String = "",
    val field: String = "",
    val facultyName: String = "",
    val teachingAssistantName: String = "",
    val onBackClick: () -> Unit = {},
    val errorMessage: String = "error",
)