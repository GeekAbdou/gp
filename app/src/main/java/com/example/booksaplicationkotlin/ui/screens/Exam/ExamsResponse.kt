package com.example.myapplicationfinal


import com.example.myapplicationfinal.Exam.ExamsData
import com.google.gson.annotations.SerializedName

data class ExamsResponse(
    @SerializedName("data")
    val `data`: ExamsData? = null,
    @SerializedName("msg")
    val msg: String? = null,
    @SerializedName("status")
    val status: Int? = null
)