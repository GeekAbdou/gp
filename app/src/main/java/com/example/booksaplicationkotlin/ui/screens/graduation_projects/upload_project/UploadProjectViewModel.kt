package com.example.readx.ui.screens.graduation_projects.upload_project

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.booksaplicationkotlin.ReadxSharedPreferences
import com.example.booksaplicationkotlin.model.Constants.SUBMITTED_GP
import com.example.booksaplicationkotlin.model.Constants.VALIDATION_FAILED
import com.example.booksaplicationkotlin.network.IReadxService
import com.example.readx.ui.Event
import com.example.readx.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UploadProjectViewModel @Inject constructor(
    private val iReadxService: IReadxService,
    private var readxSharedPreferences: ReadxSharedPreferences
) : BaseViewModel<UploadProjectUIState, UploadProjectNavigationEvent>(
    UploadProjectUIState(),
    Event()
) {

    fun uploadGradProject() {
        if (validateProjectData()) {
            val token = readxSharedPreferences.getToken() ?: ""
            Log.d("TAG", "uploadGradProject: token$token")
            viewModelScope.launch {
                try {
                    _state.update { it.copy(isLoading = true) }
                    val response =    state.value.let {
                          iReadxService.uploadGradProject(
                            token = "Bearer $token",
                            name =it.graduationProjectName,
                            field = it.field,
                            output = it.output,
                            description = it.graduationProjectDescription

                        )

                    }

                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            val message = responseBody.msg
                            val data = responseBody.data
                            // Handle successful response with message and data
                            if(message == SUBMITTED_GP)
                                _state.update { it.copy(isProjectSubmitted = true, isLoading = false) }
                            if (message==VALIDATION_FAILED) {
                                _state.update { it.copy(isProjectSubmittedError = true,isLoading = false) }

                            }
                            Log.d(tag, "Message: $message, Data: $data")
                        } else {
                            // Handle empty response body
                            Log.d(tag, "Response body is null")
                        }
                    } else {
                        // Handle API error
                        Log.e(tag, "API Error: ${response.code()} - ${response.message()}")
                    }
                } catch (e: Exception) {
                    // Handle network or other errors
                    Log.e(tag, "Request failed", e)
                }

            }
        }
    }

    private fun validateProjectData() = state.value.let {
        it.graduationProjectName.isNotEmpty() &&
                it.graduationProjectDescription.length > 100 &&
                it.field.isNotEmpty() &&
                it.output.isNotEmpty()

    }

    companion object{
        const val tag = "UploadProjectViewModel"
    }

}

