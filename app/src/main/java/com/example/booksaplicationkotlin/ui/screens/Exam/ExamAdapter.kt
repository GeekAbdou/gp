package com.example.myapplicationfinal


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.ActivityExamBinding
import com.example.myapplicationfinal.Exam.ExamRecord

class ExamAdapter(private var list: List<ExamRecord?>) :
    RecyclerView.Adapter<ExamAdapter.ExamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamViewHolder {
        ///////for convert xml to view
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_exam, parent, false)
        return ExamViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ExamViewHolder, position: Int) {
        ///convert
        val currentExam = list[position]

        holder.binding.apply {
            textViewExamName.text = currentExam!!.subjectName
            textViewAuthorname.text = currentExam!!.professorName
            textViewYear.text = currentExam!!.year.toString()
            Glide.with(imageExam).load(currentExam!!.imagePath).into(imageExam)
            root.setOnClickListener { v ->

                val bundle = Bundle().apply {
                    putString("imageUrl", currentExam.imagePath)
                }
                val navController = Navigation.findNavController(v)
                navController.navigate(R.id.action_fragment_exam_to_fragmetn_details_exam, bundle)


            }
        }


    }

    fun setItems(newItems: List<ExamRecord?>) {
        list = newItems
        notifyDataSetChanged()
    }

    class ExamViewHolder(viewitem: View) : RecyclerView.ViewHolder(viewitem) {
        val binding = ActivityExamBinding.bind(viewitem)

    }

}