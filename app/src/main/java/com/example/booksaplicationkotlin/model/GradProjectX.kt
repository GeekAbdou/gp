package com.example.booksaplicationkotlin.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@kotlinx.parcelize.Parcelize
data class GradProject(
    @SerializedName("Assistant_teacher_email")
    val assistantTeacherEmail: String?,
    @SerializedName("Assistant_teacher_name")
    val assistantTeacherName: String?,
    @SerializedName("classification")
    val classification: String?,
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
    val profEmail: String?,
    @SerializedName("Prof_name")
    val profName: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("used_technologies")
    val usedTechnologies: String?,
    @SerializedName("user_name")
    val userName: String?,
    @SerializedName("year")
    val year: String?
) : Parcelable