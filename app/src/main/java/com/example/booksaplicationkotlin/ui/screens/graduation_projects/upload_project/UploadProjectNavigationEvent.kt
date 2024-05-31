package com.example.readx.ui.screens.graduation_projects.upload_project

sealed class UploadProjectNavigationEvent {
    object NavigateBack: UploadProjectNavigationEvent()
    data class NavigateToHome(val userId: Int) : UploadProjectNavigationEvent()

}