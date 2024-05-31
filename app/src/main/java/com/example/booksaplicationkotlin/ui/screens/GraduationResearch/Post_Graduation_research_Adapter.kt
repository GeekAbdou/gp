package com.example.myapplicationresearch.GraduationResearch


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.ItemPostGraduateResearchesCardBinding
import com.example.booksaplicationkotlin.model.GraduationResearchRecord

class Post_Graduation_research_Adapter(private var list: List<GraduationResearchRecord?>) :
    RecyclerView.Adapter<Post_Graduation_research_Adapter.Post_Graduation_research_ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Post_Graduation_research_ViewHolder {
        ///////for convert xml to view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_graduate_researches_card, parent, false)
        return Post_Graduation_research_ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Post_Graduation_research_ViewHolder, position: Int) {
        ///convert
        val currentPostGraduation = list[position]

        holder.binding.apply {
            textViewPostGraduateResearch.text = currentPostGraduation!!.name
            textViewPostGraduateResearchDesc.text = currentPostGraduation.description
            textViewYear.text = currentPostGraduation.publishingYear


            root.setOnClickListener { v ->

                val bundle = Bundle().apply {
                    putString("research_name", currentPostGraduation.name)
                    putString("research_auther", currentPostGraduation.researcherName)
                    putString("research_description", currentPostGraduation.description)
                    putString("research_supervisor", currentPostGraduation.theSupervisoryAuthority)
                    putString("research_field", currentPostGraduation.field)
                    putString("research_faculty", currentPostGraduation.faculty)
                    putString("research_year", currentPostGraduation.publishingYear)
                }
                val navController = Navigation.findNavController(v)
                navController.navigate(
                    R.id.action_fragment_Post_Graduation_research_item_to_fragmetn_Post_Graduation_research_item_details,
                    bundle
                )


//                    Navigation.findNavController(v).navigate(R.id.action_fragment_Post_Graduation_research_item_to_fragmetn_Post_Graduation_research_item_details)

            }
        }

    }

    fun setItems(newItems: List<GraduationResearchRecord?>) {
        list = newItems
        notifyDataSetChanged()
    }

    class Post_Graduation_research_ViewHolder(viewitem: View) : RecyclerView.ViewHolder(viewitem) {
        val binding = ItemPostGraduateResearchesCardBinding.bind(viewitem)
    }

}