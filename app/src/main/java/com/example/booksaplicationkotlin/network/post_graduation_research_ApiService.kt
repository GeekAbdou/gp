package com.example.myapplicationresearch.networking


import com.example.booksaplicationkotlin.model.GraduationResearchResponse
import com.example.booksaplicationkotlin.model.ResearchResponse
import com.example.myapplicationfinal.ExamsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface post_graduation_research_ApiService {

    @GET("get_research")
    suspend fun getResearch() : Response<GraduationResearchResponse>



    @GET("get_research")
    suspend fun SearchResearch(@Query("query") query: String, @Query("filter") filter: String): Response<GraduationResearchResponse>


    @GET("show_exams")
    suspend fun getExams(@Query("grade") grade: String = "Fourth", @Query("subject_name") subjectName: String): Response<ExamsResponse>







    ///////باقي ال point
}

