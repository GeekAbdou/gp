package com.example.booksaplicationkotlin.network

import com.example.booksaplicationkotlin.model.BaseResponse
import com.example.booksaplicationkotlin.model.BookResponse
import com.example.booksaplicationkotlin.model.GPData
import com.example.booksaplicationkotlin.model.GradProject
import com.example.myapplicationfinal.Exam.ExamRecord
import com.example.readx.models.LoginDTO
import com.example.readx.models.ResearchDataDTO
import com.example.readx.models.signUpDTO
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface IReadxService {


    @POST("login")
    suspend fun loginUser(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<BaseResponse<LoginDTO>>

    @POST("register")
    suspend fun registerUser(
        @Query("first_name") firstName: String,
        @Query("last_name") lastName: String,
        @Query("email") email: String,
        @Query("student_id") studentId: Int,
        @Query("password") password: String,
        @Query("password_confirmation") passwordConfirmation: String,
    ): Response<BaseResponse<signUpDTO>>


    @GET("get_research")
    suspend fun getResearch(): Response<BaseResponse<ResearchDataDTO>>


    @GET("get_research")
    suspend fun searchResearch(
        @Query("query") query: String,
        @Query("filter") filter: String
    ): Response<BaseResponse<ResearchDataDTO>>


    @GET("get_books")
    suspend fun getBooks(
        @Header("Authorization") token: String,
        @Header("Accept") accept: String = "application/json"
    ): Response<BookResponse>

    @GET("search_books")
    suspend fun getSpecificBook(
        @Query("query") query: String,
        @Query("filter") filter: String,
        @Header("Accept") accept: String = "application/json"
    ): Response<BookResponse>?



    @POST("submit_GP")
    suspend fun uploadGradProject(
        @Query("name") name: String,
        @Query("description") description: String,
        @Query("field") field: String,
        @Query("output") output: String,
        @Header("Authorization") token: String
    ): Response<BaseResponse<String?>>


    @GET("show_GP")
    suspend fun getGradProjects(
        @Header("Authorization") token: String,
        @Header("Accept") accept: String = "application/json"
    ): Response<BaseResponse<List<GradProject>>>


    @GET("get_GP")
    suspend fun getSubmitGradProject(
        @Header("Authorization") token: String,
    ): Response<BaseResponse<GradProject>>



  @GET("show_exams")
    suspend fun getExams(
        @Header("Authorization") token: String,
    ): Response<BaseResponse<List<ExamRecord>>>

    @GET("search_GP")
    suspend fun getSpecificProject(
        @Header("Authorization") token: String,
        @Query("query") query:String,
        @Query("filter")filter:String,
        @Header("Accept") accept: String = "application/json"
    ):Response<BaseResponse<List<GradProject>>>?
}

