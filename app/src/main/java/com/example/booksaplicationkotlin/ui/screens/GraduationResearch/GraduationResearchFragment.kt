package com.example.myapplicationresearch.GraduationResearch


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.booksaplicationkotlin.databinding.PostGraduateResearchBinding


class GraduationResearchFragment :Fragment() {

    lateinit var binding: PostGraduateResearchBinding
    val viewModel: ResearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using data binding
        binding = PostGraduateResearchBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val post_Graduation_research_Adapter = Post_Graduation_research_Adapter(mutableListOf() )
        viewModel.reseach.observe(viewLifecycleOwner) { reseachResponse ->
            Log.d("API_RESPONSE", "Response: $reseachResponse")
            reseachResponse?.let {
                if(it.data?.records !=null) {
                    post_Graduation_research_Adapter.setItems(it.data.records!!)
                }
            }
        }


        //////search
//        binding.ChipGroup.setOnCheckedChangeListener { chipGroup, checkedId ->
//            val chip = chipGroup.findViewById<Chip>(checkedId)
//            val query = binding.searchBar.text.toString()
//            viewModel.searchResearch(query, chip.text.toString())
//        }

        val professorChip = binding.professor
        val fieldChip =binding.field
        val supervisorChip = binding.supervisor
        val paperNameChip = binding.paperName

        professorChip.setOnClickListener {
            val editText = binding.searchBar
            val text = editText.text.toString()
            viewModel.searchResearch("Professor", text)
        }

        fieldChip.setOnClickListener {
            val editText = binding.searchBar
            val text = editText.text.toString()
            viewModel.searchResearch("Field", text)
        }

        supervisorChip.setOnClickListener {
            val editText = binding.searchBar
            val text = editText.text.toString()
            viewModel.searchResearch("Supervisor", text)
        }

        paperNameChip.setOnClickListener {
            val editText = binding.searchBar
            val text = editText.text.toString()
            viewModel.searchResearch("Paper name", text)
        }


        binding.RecycelerViewPGR.adapter = post_Graduation_research_Adapter





    }


}