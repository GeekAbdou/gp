package com.example.booksaplicationkotlin.model


import com.google.gson.annotations.SerializedName

data class GraduationResearchRecord(
    @SerializedName("category")
    val category: Any? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("faculty")
    val faculty: String? = null,
    @SerializedName("field")
    val `field`: String? = null,
    @SerializedName("file")
    val `file`: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("publishing_year")
    val publishingYear: String? = null,
    @SerializedName("researcher_email")
    val researcherEmail: String? = null,
    @SerializedName("researcher_name")
    val researcherName: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("the supervisory authority")
    val theSupervisoryAuthority: String? = null
)