package com.example.myapplicationfinal.Exam


import com.google.gson.annotations.SerializedName

data class ExamsData(
    @SerializedName("pagination links")
    val paginationLinks: ExamsPaginationLinks? = null,
    @SerializedName("records")
    val records: List<ExamRecord?>? = null
)