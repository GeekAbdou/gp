package com.example.readx.ui.screens.graduation_projects.projects_viewall

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.booksaplicationkotlin.ReadxSharedPreferences
import com.example.booksaplicationkotlin.network.IReadxService
import com.example.readx.ui.Event
import com.example.readx.ui.base.BaseViewModel
import com.example.readx.ui.screens.graduation_projects.GraduationProjectsNavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GraduationProjectsViewallViewModel @Inject constructor(
    private val iReadxService: IReadxService,
    private var readxSharedPreferences: ReadxSharedPreferences
) : BaseViewModel<GraduationProjectsViewallUIState, GraduationProjectsViewallNavigationEvent>(
    GraduationProjectsViewallUIState(),
    Event()
) {
    init {
        getAllGradProjects()
    }

    private fun getAllGradProjects() {
        Log.d("TAG", "getAllGradProjects: ")
        viewModelScope.launch {
            try {
                val token = readxSharedPreferences.getToken() ?: ""
                val response = iReadxService.getGradProjects("Bearer $token")

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val message = responseBody.msg
                        val data = responseBody.data
                        _state.update {
                            it.copy(graduationProjects = data!!, isLoading = false)
                        }
                        Log.d(TAG, "Message: $message, Data: $data")
                    } else {
                        // Handle empty response body
                        Log.d(TAG, "Response body is null")
                    }
                } else {
                    // Handle API error
                    Log.e(TAG, "API Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e(TAG, "Request failed", e)
            }

        }
    }

    companion object {
        const val TAG = "GraduationProjectsViewallViewModel"
    }
}

