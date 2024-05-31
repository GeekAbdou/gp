package com.example.myapplicationfinal.Exam


import com.google.gson.annotations.SerializedName

data class ExamsPaginationLinks(
    @SerializedName("current page")
    val currentPage: Int? = null,
    @SerializedName("links")
    val links: ExamsLinks? = null,
    @SerializedName("per page")
    val perPage: Int? = null,
    @SerializedName("total")
    val total: Int? = null
)