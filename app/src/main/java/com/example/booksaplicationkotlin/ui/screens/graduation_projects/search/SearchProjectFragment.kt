package com.example.booksaplicationkotlin.ui.screens.graduation_projects.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentSearchGradBinding
import com.example.booksaplicationkotlin.model.GradProject
import com.example.booksaplicationkotlin.model.Record
import com.example.booksaplicationkotlin.ui.screens.allbooks.Resources
import com.example.booksaplicationkotlin.ui.screens.allbooks.view.OnClickListener
import com.example.booksaplicationkotlin.ui.screens.allbooks.view.SearchBookFragmentDirections
import com.google.android.material.card.MaterialCardView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchProjectFragment : Fragment(), OnClickListener {

    lateinit var binding: FragmentSearchGradBinding
    val searchBooksViewModel: SearchProjectViewModel by viewModels()
    lateinit var bookAdapter: GraduationProjectsAdapter
    var searchFlag: String = "Name"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookAdapter = GraduationProjectsAdapter(object : GradProjectInteractionListener {
            override fun onClickGradProject(gradProject: GradProject) {
                Log.d("MAMO", "onClickGradProject:gradProject$gradProject ")
                val action =
                    SearchProjectFragmentDirections.actionSearchProjectFragmentToGPDetailsFragment(
                        gradProject
                    )
                findNavController().navigate(action)
            }
        })

        observeOnSelectedBooks()

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_grad, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TAG", "onViewCreated: ${binding.filterLayout.requestFocus()}")
        binding.adapter = bookAdapter

        binding.projectsRecyclerview.apply {
            this.layoutManager = LinearLayoutManager(requireContext())
        }
        binding.resultToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.filterName.setOnClickListener {
            clearSelectedFilter()
            binding.bookSearchbar.text = ""
            binding.filterName.strokeWidth = 4
            binding.filterName.strokeColor = getResources().getColor(R.color.teal_700)
            binding.projectNameText.setTextColor(getResources().getColor(R.color.teal_700))
            searchFlag = "Name"
        }
        binding.filterAuthor.setOnClickListener {
            clearSelectedFilter()
            binding.bookSearchbar.text = ""
            binding.filterAuthor.strokeWidth = 4
            binding.filterAuthor.strokeColor = getResources().getColor(R.color.teal_700)
            binding.supervisorText.setTextColor(getResources().getColor(R.color.teal_700))
            searchFlag = "Supervisor"
        }
        binding.filterField.setOnClickListener {
            clearSelectedFilter()
            binding.bookSearchbar.text = ""
            binding.filterField.strokeWidth = 4
            binding.filterField.strokeColor = getResources().getColor(R.color.teal_700)
            binding.fieldText.setTextColor(getResources().getColor(R.color.teal_700))
            searchFlag = "Field"
        }
        binding.filterYear.setOnClickListener {
            clearSelectedFilter()
            binding.bookSearchbar.text = ""
            binding.filterYear.strokeWidth = 4
            binding.filterYear.strokeColor = getResources().getColor(R.color.teal_700)
            binding.teamMemberText.setTextColor(getResources().getColor(R.color.teal_700))
            searchFlag = "TeamMember"
        }


        binding.bookSearchbar.addTextChangeListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                Log.d("TAG", "beforeTextChanged: ")

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 0) {
                    bookAdapter.setItems(listOf())

                } else {
                    if (searchFlag == "Name")
                        searchBooksViewModel.searchByName(s.toString())
                    else if (searchFlag == "Supervisor")
                        searchBooksViewModel.searchBySupervisor(s.toString())
                    else if (searchFlag == "Field")
                        searchBooksViewModel.searchByField(s.toString())
                    else if (searchFlag == "TeamMember")
                        searchBooksViewModel.searchByTeamMember(s.toString())

                }


            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("TAG", "afterTextChanged: ")


            }

        })
    }


    private fun observeOnSelectedBooks() {
        lifecycleScope.launch {
            searchBooksViewModel.selectedBooks.collect {
                when (it) {

                    is Resources.Success -> {
                        Log.d("TAG", "observeOnSelectedBooks:${it} ")
                        if (it.data?.size!! > 0) {
                            binding.noResultTxt.visibility = View.GONE
                            binding.noBooksImg.visibility = View.GONE
                            binding.filterLayout.visibility = View.VISIBLE
                            binding.projectsRecyclerview.visibility = View.VISIBLE

                            Log.d("MAMO", "observeOnSelectedBooks:projects ${it.data} ")
                            bookAdapter.setItems(it.data)
                        } else {

                            binding.projectsRecyclerview.visibility = View.INVISIBLE
                            binding.noResultTxt.visibility = View.VISIBLE
                            binding.noBooksImg.visibility = View.VISIBLE
                        }

                    }

                    is Resources.Error -> {
                    }

                    else -> {

                    }
                }

            }
        }
    }

    override fun onClickBookItem(record: Record) {
        val action =
            SearchBookFragmentDirections.actionSearchBookFragmentToBookDetailsFragment(record)
        findNavController().navigate(action)

    }

    fun clearSelectedFilter() {
        val layout: LinearLayout = binding.filterLayout
        val count = layout.childCount
        for (i in 0 until count) {
            val childView = layout.getChildAt(i)
            if (childView is MaterialCardView) {
                val cardView = childView
                cardView.strokeWidth = 0
                val textView = childView.getChildAt(0)
                if (textView is TextView)
                    textView.setTextColor(resources.getColor(R.color.black))
                // Example: Change background color

            }

        }
    }


}

