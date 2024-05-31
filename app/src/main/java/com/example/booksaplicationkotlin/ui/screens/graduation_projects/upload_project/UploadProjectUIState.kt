package com.example.readx.ui.screens.graduation_projects.upload_project

data class UploadProjectUIState(
    var graduationProjectName: String = "",
    var field: String = "",
    var output: String = "",
    var graduationProjectDescription: String = "",
    val isProjectSubmitted: Boolean = false,
    val isProjectSubmittedError: Boolean = false,
    val isLoading: Boolean = false
)
