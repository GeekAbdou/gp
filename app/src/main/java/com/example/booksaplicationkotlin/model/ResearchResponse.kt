package com.example.booksaplicationkotlin.model


import com.google.gson.annotations.SerializedName

data class ResearchResponse(
    @SerializedName("data")
    val `data`: Data? = null,
    @SerializedName("msg")
    val msg: String? = null,
    @SerializedName("status")
    val status: Int? = null
)

data class GraduationResearchResponse(
    @SerializedName("data")
    val `data`: GraduationResearchData? = null,
    @SerializedName("msg")
    val msg: String? = null,
    @SerializedName("status")
    val status: Int? = null
)