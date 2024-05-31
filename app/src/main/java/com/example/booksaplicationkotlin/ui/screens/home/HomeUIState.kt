package com.example.booksaplicationkotlin.ui.screens.home

import com.example.booksaplicationkotlin.model.GPData
import com.example.booksaplicationkotlin.model.GradProject
import com.example.booksaplicationkotlin.model.Record
import com.example.myapplicationfinal.Exam.ExamRecord

data class HomeUIState(
    val isAuthorized: Boolean = false,
    val isLoading: Boolean = true,
    val exams: List<ExamRecord> = emptyList(),
    val gradProjects:List<GradProject> = emptyList(),
    val books:List<Record> = emptyList()
)