package com.example.booksaplicationkotlin.network

import com.example.booksaplicationkotlin.model.BaseResponse
import com.example.booksaplicationkotlin.model.BookResponse
import com.example.booksaplicationkotlin.model.RateResponse
import com.example.myapplicationfinal.ExamsResponse
import com.example.readx.models.LoginDTO
import com.example.readx.models.ResearchDataDTO
import com.example.readx.models.signUpDTO
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {


    @GET("get_books")
    suspend fun getBooks(@Header("Authorization") token: String,@Header("Accept") accept: String = "application/json"
    ): Response<BookResponse>?

    @GET("search_books")
    suspend fun getSpecificBook(@Query("query") query:String,@Query("filter")filter:String,@Header("Accept") accept: String = "application/json"
    ):Response<BookResponse>?

    @POST("rate_a_book")
    @FormUrlEncoded
    suspend fun rateBook(@Header("Authorization") token: String,
                         @Field("id") id:Int, @Field("rate")rate:Float,  @Header("Accept") accept: String = "application/json"): Response<RateResponse>?




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


    @GET("show_exams")
    suspend fun getExams(@Query("grade") grade: String = "Fourth", @Query("subject_name") subjectName: String): Response<ExamsResponse>



}