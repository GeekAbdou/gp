package com.example.booksaplicationkotlin.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class BaseResponse<T>(
    @SerializedName("status")
    val status: Int?,
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("data")
    val data: T?,
)

data class GPData(
    @SerializedName("records")
    val records: List<GPRecord>,
    @SerializedName("pagination links")
    val paginationLinks: PaginationLinks,
)

data class GPRecord(
    @SerializedName("Assistant_teacher_email")
    val assistantTeacherEmail: Any?,
    @SerializedName("Assistant_teacher_name")
    val assistantTeacherName: Any?,
    @SerializedName("classification")
    val classification: Any?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("faculty")
    val faculty: String?,
    @SerializedName("field")
    val `field`: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("output")
    val output: String?,
    @SerializedName("Prof_email")
    val profEmail: Any?,
    @SerializedName("Prof_name")
    val profName: Any?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("used_technologies")
    val usedTechnologies: Any?,
    @SerializedName("year")
    val year: String?
)

data class PaginationLinks(
    @SerializedName("current page")
    var currentPage: Int?,
    @SerializedName("links")
    var links: Links?,
    @SerializedName("per page")
    var perPage: Int?,
    @SerializedName("total")
    var total: Int?
)

data class Links(
    @SerializedName("first")
    var first: String?,
    @SerializedName("last")
    var last: String?,
    @SerializedName("next")
    var next: String?,
    @SerializedName("previous")
    var previous: Any?
)

