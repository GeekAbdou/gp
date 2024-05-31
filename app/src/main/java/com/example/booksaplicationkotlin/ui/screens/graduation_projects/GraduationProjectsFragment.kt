package com.example.readx.ui.screens.graduation_projects

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.databinding.FragmentGraduationProjectsBinding
import com.example.readx.ui.base.BaseFragment
import com.example.readx.ui.base.BaseFragmentsAdapter
import com.example.readx.ui.screens.graduation_projects.gp_plagiarism.GraduationProjectPlagiarismFragment
import com.example.readx.ui.screens.graduation_projects.gp_status.GraduationProjectStatusFragment
import com.example.readx.ui.screens.graduation_projects.projects_viewall.GraduationProjectsViewallFragment
import com.example.readx.ui.screens.graduation_projects.upload_project.UploadProjectFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GraduationProjectsFragment() :
    BaseFragment<FragmentGraduationProjectsBinding>() {
    override val layoutIdFragment = R.layout.fragment_graduation_projects
    override val viewModel: GraduationProjectsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.bookSearchbar.setOnClickListener {
            findNavController().navigate(R.id.action_graduationProjectsFragment_to_searchProjectFragment)

        }
        val fragments = listOf(
            GraduationProjectsViewallFragment(),
            UploadProjectFragment(),
            GraduationProjectPlagiarismFragment(), GraduationProjectStatusFragment(),
        )

        val fragmentsAdapter = BaseFragmentsAdapter(
            childFragmentManager,
            requireActivity().lifecycle, fragments
        )
        binding.viewPagerTab.adapter = fragmentsAdapter
        TabLayoutMediator(binding.tabGp, binding.viewPagerTab) { tab, position ->
            when (position) {
                0 -> tab.text = "Projects"
                1 -> tab.text = "Upload"
                2 -> tab.text = "Plagiarism"
                else -> tab.text = "Status"

            }
        }.attach()
        binding.tabGp.getTabAt(0)?.let { tab ->
            tab.view.setBackgroundResource(R.drawable.selscted_tab)
            val tabTextView = (tab?.view?.getChildAt(1) as? TextView)
            tabTextView?.setTextColor(Color.WHITE)
        }
        binding.tabGp.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //  tab?.view?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.primaryColor))
                tab?.view?.setBackgroundResource(R.drawable.selscted_tab)

                val tabTextView = (tab?.view?.getChildAt(1) as? TextView)
                tabTextView?.setTextColor(Color.WHITE)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Reset background color to default when tab is unselected
                //    tab?.view?.setBackgroundColor(Color.TRANSPARENT)
                val tabTextView = (tab?.view?.getChildAt(1) as? TextView)
                tabTextView?.setTextColor(Color.BLACK)
                tab?.view?.setBackgroundColor(Color.TRANSPARENT)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }


}
/*
private lateinit var _binding: FragmentGraduationProjectsBinding

    private val tabTitles = arrayListOf("Projects", "Upload", "Plagiarism", "Status")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setUpTabLayoutWithViewPager()


        return binding.root
    }

    private fun setUpTabLayoutWithViewPager() {
        binding.viewPagerTab.adapter = GraduationProjectAdapter(this)
        TabLayoutMediator (binding.tabGp, binding.viewPagerTab) { tab, position ->
            tab.text = tabTitles[position]

        }.attach()
         for (i in 0..3) {
            val textView =
                LayoutInflater.from(requireContext()).inflate(R.layout.tab_title,  null)
            as TextView
            binding.tabGp.getTabAt(i)?.customView = textView

        }
        }
    }*/