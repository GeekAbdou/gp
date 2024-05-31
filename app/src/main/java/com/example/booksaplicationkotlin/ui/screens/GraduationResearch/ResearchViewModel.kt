package com.example.myapplicationresearch.GraduationResearch


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksaplicationkotlin.model.GraduationResearchResponse
import com.example.booksaplicationkotlin.model.ResearchRepository
import kotlinx.coroutines.launch


class ResearchViewModel() : ViewModel() {
    //    ,post_graduation_research_Recyclerinteraction{
    private val _navigateToDetails = MutableLiveData<String>()
    val navigateToDetails: LiveData<String> = _navigateToDetails


    val repository = ResearchRepository()
    private val _reseach = MutableLiveData<GraduationResearchResponse>()
    val reseach: LiveData<GraduationResearchResponse?> = _reseach


    init {
        getResearch()

    }

    private fun getResearch() {
        viewModelScope.launch {
            repository.getResearch().collect() {
                _reseach.postValue(it)
            }
        }
    }


    public fun searchResearch(query: String, filter: String) {
        viewModelScope.launch {
            repository.searchResearch(query, filter).collect() {
                _reseach.postValue(it)
            }
        }
    }


}




