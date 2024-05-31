package com.example.booksaplicationkotlin.ui.screens.allbooks.view

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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentSearchBookBinding
import com.example.booksaplicationkotlin.db.ConcereteLocalSource
import com.example.booksaplicationkotlin.model.Record
import com.example.booksaplicationkotlin.model.Repository
import com.example.booksaplicationkotlin.network.ApiClient
import com.example.booksaplicationkotlin.ui.screens.allbooks.Resources
import com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel.SearchBookViewModel
import com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel.SearchBookViewModelFactory
import com.google.android.material.card.MaterialCardView
import kotlinx.coroutines.launch


class SearchBookFragment : Fragment(), OnClickListener {

    lateinit var binding: FragmentSearchBookBinding
    lateinit var searchBooksViewModel:SearchBookViewModel
    lateinit var  bookAdapter :BooksAdapter
    var searchFlag:String = "Name"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val searchBooksViewModelFactor = SearchBookViewModelFactory(
            Repository.getInstance(
                ApiClient.getInstance(),
                ConcereteLocalSource(requireContext())
            ))
        searchBooksViewModel = ViewModelProvider(this,searchBooksViewModelFactor).get(SearchBookViewModel::class.java)
        bookAdapter = BooksAdapter(this)

        observeOnSelectedBooks()

    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_book,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TAG", "onViewCreated: ${binding.filterLayout.requestFocus()}")
        binding.adapter = bookAdapter

        binding.booksRecyclerview.apply {
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
            binding.nameText.setTextColor(getResources().getColor(R.color.teal_700))
            searchFlag = "Name"
        }
        binding.filterAuthor.setOnClickListener {
            clearSelectedFilter()
            binding.bookSearchbar.text = ""
            binding.filterAuthor.strokeWidth = 4
            binding.filterAuthor.strokeColor = getResources().getColor(R.color.teal_700)
            binding.authorText.setTextColor(getResources().getColor(R.color.teal_700))
            searchFlag = "Author"
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
            binding.yearText.setTextColor(getResources().getColor(R.color.teal_700))
            searchFlag = "Year"
        }


        binding.bookSearchbar.addTextChangeListener(object :TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                Log.d("TAG", "beforeTextChanged: ")

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s?.length == 0){
                    bookAdapter.submitList(listOf())

                }else {
                    if (searchFlag == "Name")
                        searchBooksViewModel.searchByName(s.toString())
                    else if (searchFlag == "Author")
                        searchBooksViewModel.searchByAuthor(s.toString())
                    else if (searchFlag == "Field")
                        searchBooksViewModel.searchByField(s.toString())
                    else if (searchFlag == "Year")
                        searchBooksViewModel.searchByYear(s.toString())

                }


            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("TAG", "afterTextChanged: ")


            }

        })
    }


    private fun observeOnSelectedBooks(){
        lifecycleScope.launch {
            searchBooksViewModel.selectedBooks.collect{
                when(it){

                    is Resources.Success ->{
                        Log.d("TAG", "observeOnSelectedBooks:${it} ")
                        if(it.data?.size!! > 0) {
                            binding.noResultTxt.visibility = View.GONE
                            binding.noBooksImg.visibility = View.GONE
                            binding.filterLayout.visibility =View.VISIBLE
                            binding.booksRecyclerview.visibility = View.VISIBLE

                            bookAdapter.submitList(it.data)
                        }
                        else {

                            binding.booksRecyclerview.visibility = View.INVISIBLE
                            binding.noResultTxt.visibility = View.VISIBLE
                            binding.noBooksImg.visibility = View.VISIBLE
                        }

                    }
                    is Resources.Error ->{
                    }
                    else -> {

                    }
                }

            }
        }
    }

    override fun onClickBookItem(record: Record) {
        val action = SearchBookFragmentDirections.actionSearchBookFragmentToBookDetailsFragment(record)
        findNavController().navigate(action)

    }
    fun clearSelectedFilter(){
        val layout: LinearLayout = binding.filterLayout
        val count = layout.childCount
        for (i in 0 until count ) {
            val childView = layout.getChildAt(i)
            if (childView is MaterialCardView) {
                val cardView = childView
                cardView.strokeWidth = 0
                val textView = childView.getChildAt(0)
                if(textView is TextView)
                    textView.setTextColor(resources.getColor(R.color.black))
                // Example: Change background color

            }

        }
    }


}

