package com.example.booksaplicationkotlin.ui.screens.graduation_projects.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksaplicationkotlin.ReadxSharedPreferences
import com.example.booksaplicationkotlin.model.BaseResponse
import com.example.booksaplicationkotlin.model.GradProject
import com.example.booksaplicationkotlin.network.IReadxService
import com.example.booksaplicationkotlin.ui.screens.allbooks.Resources
import com.example.readx.ui.screens.graduation_projects.upload_project.UploadProjectViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SearchProjectViewModel @Inject constructor(
    private val iReadxService: IReadxService,
    private var readxSharedPreferences: ReadxSharedPreferences
) : ViewModel() {

    private val mutableSelectedBooks: MutableStateFlow<Resources<List<GradProject>>> =
        MutableStateFlow(
            Resources.Loading()
        )

    val selectedBooks: StateFlow<Resources<List<GradProject>>> = mutableSelectedBooks

    fun searchByName(data: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val token = readxSharedPreferences.getToken() ?: ""

            try {
                val response = iReadxService
                    .getSpecificProject(
                        query = data,
                        filter = "name",
                        token = "Bearer $token"
                    )

                extracted(response)
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e(UploadProjectViewModel.tag, "Request failed", e)
            }

        }

    }

    private fun extracted(response: Response<BaseResponse<List<GradProject>>>?) {
        if (response != null) {
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    val message = responseBody.msg
                    val data = responseBody.data
                    // Handle successful response with message and data
                    mutableSelectedBooks.value = Resources.Success(data)



                    Log.d(UploadProjectViewModel.tag, "Message: $message, Data: $data")
                } else {
                    // Handle empty response body
                    mutableSelectedBooks.value = Resources.Error("Response body is null")

                    Log.d(UploadProjectViewModel.tag, "Response body is null")
                }
            } else {
                mutableSelectedBooks.value =
                    Resources.Error("API Error: ${response.code()} - ${response.message()}")
                Log.e(
                    UploadProjectViewModel.tag,
                    "API Error: ${response.code()} - ${response.message()}"
                )
            }
        }
    }

    fun searchBySupervisor(data: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val token = readxSharedPreferences.getToken() ?: ""

            try {
                val response = iReadxService .getSpecificProject(
                    query = data,
                    filter = "Supervisor",
                    token = "Bearer $token"
                )
                extracted(response)
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e(UploadProjectViewModel.tag, "Request failed", e)
            }

        }

    }

    fun searchByField(data: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val token = readxSharedPreferences.getToken() ?: ""

            try {
                val response = iReadxService .getSpecificProject(
                    query = data,
                    filter = "field",
                    token = "Bearer $token"
                )
                extracted(response)
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e(UploadProjectViewModel.tag, "Request failed", e)
            }

        }

    }

    fun searchByTeamMember(data: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val token = readxSharedPreferences.getToken() ?: ""

                val response =
                    iReadxService .getSpecificProject(
                        query = data,
                        filter = "status",
                        token = "Bearer $token"
                    )
                extracted(response)
            } catch (e: Exception) {
                // Handle network or other errors
                Log.e(UploadProjectViewModel.tag, "Request failed", e)
            }

        }

    }


}