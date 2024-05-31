package com.example.booksaplicationkotlin.ui.screens.allbooks.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel.BookDetailsViewModel


import com.example.booksaplicationkotlin.databinding.FragmentBookDetailsBinding
import com.example.booksaplicationkotlin.db.ConcereteLocalSource
import com.example.booksaplicationkotlin.model.Repository
import com.example.booksaplicationkotlin.network.ApiClient
import com.example.booksaplicationkotlin.ui.screens.allbooks.Resources
import com.example.booksaplicationkotlin.ui.screens.allbooks.view.BookDetailsFragmentArgs
import com.example.booksaplicationkotlin.ui.screens.allbooks.viewmodel.BookDetailsViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response


class BookDetailsFragment : Fragment() {

    lateinit var binding: FragmentBookDetailsBinding
    private lateinit var args: BookDetailsFragmentArgs
    private lateinit var bookDetailsViewModel: BookDetailsViewModel
    private val token = "27|dJ39KzrnAqM3FU8cteBs18xXV3oVRRtyRhHmBvTv01e93cac"

    private var rating = 0.0;
    override fun onSaveInstanceState(outState: Bundle) {
        //Add this note in problems
        super.onSaveInstanceState(outState)
        outState.putFloat("rating", binding.ratingBar.rating)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*  // why this always is null
          if(savedInstanceState != null){
              Log.d("TAG", "rating: ${savedInstanceState.getFloat("rating")} ")
             // binding.ratingBar.rating = savedInstanceState.getFloat("rating").toFloat()
          }else{
              Log.d("TAG", "rating: ${savedInstanceState?.getFloat("rating")} ")

          }*/
        val bookDetailsViewModelFactor = BookDetailsViewModelFactory(
            Repository.getInstance(
                ApiClient.getInstance(),
                ConcereteLocalSource(requireContext())
            ))
        bookDetailsViewModel = ViewModelProvider(this,bookDetailsViewModelFactor).get(BookDetailsViewModel::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_book_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        args = navArgs<BookDetailsFragmentArgs>().value
        binding.book = args.book


        binding.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            lifecycleScope.launch {

                this@BookDetailsFragment.rating = rating.toDouble()
                bookDetailsViewModel.rateBook(token, id, rating)
                bookDetailsViewModel._response.collect {
                    when (it) {
                        is Resources.Success -> {
                            Toast.makeText(
                                requireContext(),
                                it.message.toString(),
                                Toast.LENGTH_LONG
                            )
                        }

                        is Resources.Loading -> {}
                        is Resources.Error -> {
                            Toast.makeText(
                                requireContext(),
                                it.message.toString(),
                                Toast.LENGTH_LONG
                            )
                        }

                        else -> {}
                    }
                }
            }
        }

        binding.showMoreTxt.setOnClickListener {
            if (binding.showMoreTxt.text == "Show more") {
                binding.showMoreTxt.text = "Show Less"
                binding.showArrow.setImageResource(R.drawable.show_less_arrow)
                binding.bookDetailsDescription.apply {
                    this.text = args.book.description
                    this.maxLines = 100
                }


            } else {
                binding.showMoreTxt.text = "Show more"
                binding.showArrow.setImageResource(R.drawable.show_more_arrow)
                binding.bookDetailsDescription.apply {
                    this.text = args.book.description + "..."
                    this.maxLines = 2
                }
            }
        }

        //new
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.booksFragment)
            }
        })
    }


}