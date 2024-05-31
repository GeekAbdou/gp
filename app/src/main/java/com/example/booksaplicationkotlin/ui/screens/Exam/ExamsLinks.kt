package com.example.myapplicationfinal.Exam


import com.google.gson.annotations.SerializedName

data class ExamsLinks(
    @SerializedName("first")
    val first: String? = null,
    @SerializedName("last")
    val last: String? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: Any? = null
)