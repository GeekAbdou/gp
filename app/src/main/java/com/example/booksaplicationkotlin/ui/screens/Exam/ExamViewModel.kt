package com.example.myapplicationfinal


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class ExamViewModel() :ViewModel() {

    val repository = ExamRepository()
    private val _exam = MutableLiveData<ExamsResponse>()
    val exam: LiveData<ExamsResponse?> = _exam


    private val data = MutableLiveData<String>()


//    init {
//        // Observe changes in data LiveData
//        data.observeForever{ subject ->
//            subject?.let {
//                getExam(it)
//            }
//        }
//    }

    public fun getExam(subject:String) {
        viewModelScope.launch {
            repository.getExam(subject).collect() {
                _exam.postValue(it)
            }
        }
    }


//
//    fun setData(item:String){
//        data.value=item
//    }
//
//    fun getData():LiveData<String>{
//        return data
//    }
}




