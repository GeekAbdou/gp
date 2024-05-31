package com.example.myapplicationfinal.Exam


import com.google.gson.annotations.SerializedName

data class ExamRecord(
    @SerializedName("grade")
    val grade: String? = null,
    @SerializedName("image_path")
    val imagePath: String? = null,
    @SerializedName("professor_name")
    val professorName: String? = null,
    @SerializedName("subject_name")
    val subjectName: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("year")
    val year: Int? = null
)