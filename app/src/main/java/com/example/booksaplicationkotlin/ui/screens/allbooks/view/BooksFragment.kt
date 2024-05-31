package com.example.booksaplicationkotlin.ui.screens.allbooks.view

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.ReadxSharedPreferences
import com.example.booksaplicationkotlin.books.viewmodel.BooksViewModelFactor
import com.example.booksaplicationkotlin.databinding.FragmentBooksBinding
import com.example.booksaplicationkotlin.db.ConcereteLocalSource
import com.example.booksaplicationkotlin.model.Record
import com.example.booksaplicationkotlin.model.Repository
import com.example.booksaplicationkotlin.network.ApiClient
import com.example.booksaplicationkotlin.ui.screens.allbooks.Resources
import com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel.allBooksViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BooksFragment : Fragment(), OnClickListener {

    private lateinit var booksViewModel: allBooksViewModel
    private lateinit var bookAdapter: BooksAdapter
    lateinit var binding: FragmentBooksBinding


    private val sharedPreferences by lazy {
        activity?.application?.getSharedPreferences(
            "ReadxSharedPreference",
            Context.MODE_PRIVATE
        )
    }

    private val readxSharedPreferences by lazy { sharedPreferences?.let { ReadxSharedPreferences(it) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val booksViewModelFactor = BooksViewModelFactor(
            Repository.getInstance(
                ApiClient.getInstance(),
                ConcereteLocalSource(requireContext())
            )
        )
        booksViewModel =
            ViewModelProvider(this, booksViewModelFactor).get(allBooksViewModel::class.java)
        bookAdapter = BooksAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // adapter = BooksAdapter(arrayListOf())
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_books, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        observeBooksFromDatabase()
        observeBooksFromApi()


        binding.adapter = bookAdapter

        binding.booksRecyclerview.apply {
            this.adapter = bookAdapter
            this.layoutManager = LinearLayoutManager(requireContext())
        }

        binding.bookSearchbar.setOnClickListener {
            findNavController().navigate(R.id.action_booksFragment_to_searchBookFragment)

        }

        val token = readxSharedPreferences?.getToken() ?: ""
        if (isNetworkAvailable())
            booksViewModel.getBooks(token)
        else
            booksViewModel.getBooksFromDatabase()
    }

    fun observeBooksFromApi() {

        lifecycleScope.launch {
            booksViewModel.all_books.collect {
                when (it) {
                    is Resources.Success -> {
                        withContext(Dispatchers.Main) {
                            binding.allBookProgressbar.visibility = View.INVISIBLE
                            Log.d("TAG", "observeBooksFromApi: ${it.data?.data}")
                            Log.d("TAG", "onViewCreated: ${it.data}")
                            bookAdapter.submitList(it.data?.data)
                            //it.data?.data?.let { it1 -> booksViewModel.insertBooks(it1) }
                            binding.bookSearchbar.isSearchOpened
                        }
                    }

                    is Resources.Error -> {
                        binding.allBookProgressbar.visibility = View.INVISIBLE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }

                    is Resources.Loading -> {
                        /* binding.allBookProgressbar.visibility = View.VISIBLE
                         Toast.makeText(requireContext(),"Loading", Toast.LENGTH_LONG).show()*/
                    }

                    else -> {}
                }

            }
        }
    }

    private fun observeBooksFromDatabase() {

        lifecycleScope.launch {
            booksViewModel.booksFromRoom.collect {
                when (it) {
                    is Resources.Success -> {
                        withContext(Dispatchers.Main) {
                            binding.allBookProgressbar.visibility = View.INVISIBLE
                            bookAdapter.submitList(it.data)
                            // binding.bookSearchbar.isSearchOpened
                        }
                    }

                    is Resources.Error -> {
                        binding.allBookProgressbar.visibility = View.INVISIBLE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }

                    is Resources.Loading -> {
                        /* binding.allBookProgressbar.visibility = View.VISIBLE
                         Toast.makeText(requireContext(),"Loading", Toast.LENGTH_LONG).show()*/
                    }

                    else -> {}
                }

            }
        }

    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override fun onClickBookItem(record: Record) {
        Log.d("TAG", "onClickBookItem: $record ")
        val action = BooksFragmentDirections.actionBooksFragmentToBookDetailsFragment(record)
        findNavController().navigate(action)
    }


}