package com.example.booksaplicationkotlin.model


import com.example.myapplicationresearch.networking.post_graduation_research_Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ResearchRepository {
    suspend fun getResearch() : Flow<GraduationResearchResponse?>{
//        return  flow {
//            emit(post_graduation_research_Api.apiService.getResearch().body())
        
            return flow {
                try {
                    val response = post_graduation_research_Api.apiService.getResearch()
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





    suspend fun  searchResearch(query : String , filter : String):Flow<GraduationResearchResponse?>{
//        return  flow {
//            emit(post_graduation_research_Api.apiService.SearchResearch(query, filter).body())
        return flow {
            try {
                val response = post_graduation_research_Api.apiService.SearchResearch(query, filter)
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