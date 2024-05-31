package com.example.myapplicationfinal

import com.example.booksaplicationkotlin.model.ResearchRepository
import com.example.myapplicationresearch.networking.post_graduation_research_Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ExamRepository {


//    suspend fun getExam() : Flow<ExamsResponse?>{
//        return  flow {
//            emit(API.apiService.getExams("First", "pariatur").body())
//        }
//    }


    suspend fun getExam(subject:String): Flow<ExamsResponse?> {
        return flow {
            try {
                val response = post_graduation_research_Api.apiService.getExams("Fourth", subject)
                if (response.isSuccessful) {
                    emit(response.body())
                } else {
                    // Handle unsuccessful response
                    emit(null)
                }
            } catch (e: Exception) {
                // Handle network errors
                emit(null)
            }
        }
    }

}