package com.example.myapplicationfinal


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.booksaplicationkotlin.databinding.ActivityRecyclerexamBinding

class fragmentExam : Fragment() {

    lateinit var binding: ActivityRecyclerexamBinding
    val viewModel: ExamViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using data binding
        binding = ActivityRecyclerexamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val subjectName = arguments?.getString("subjectName")
        //viewModel = ViewModelProvider(this, ExamViewModel( subjectName!! )).get(ExamViewModel::class.java)
//        viewModel= ViewModelProvider(requireActivity()).get(ExamViewModel::class.java)
//        viewModel.setData(subjectName!!)

        //////or make this delete paramter from viewmodel class make function get exam public
        //// call funtion
        viewModel.getExam(subjectName!!)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        val examAdapter = ExamAdapter(mutableListOf())
//        viewModel.exam.observe(viewLifecycleOwner) { examsResponse ->
//            examsResponse?.let {
//                if(it.data.records !=null) {
//                    examAdapter.setItems(it.data.records)
//                }
//            }
//        }


        val examAdapter = ExamAdapter(mutableListOf())
        viewModel.exam.observe(viewLifecycleOwner) { examsResponse ->
            Log.d("API_RESPONSE", "Response: $examsResponse")
            examsResponse?.let { response ->
                response.data?.records?.let { records ->
                    examAdapter.setItems(records)
                }
            }
        }


        binding.recyclerexam.adapter = examAdapter


    }


}