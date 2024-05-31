package com.example.readx.ui.screens.graduation_projects

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.readx.ui.screens.graduation_projects.gp_plagiarism.GraduationProjectPlagiarismFragment
import com.example.readx.ui.screens.graduation_projects.gp_status.GraduationProjectStatusFragment
import com.example.readx.ui.screens.graduation_projects.projects_viewall.GraduationProjectsViewallFragment
import com.example.readx.ui.screens.graduation_projects.upload_project.UploadProjectFragment

class GraduationProjectAdapter(fragment: GraduationProjectsFragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GraduationProjectsViewallFragment()
            1 -> UploadProjectFragment()
            2 ->GraduationProjectPlagiarismFragment()
            else -> GraduationProjectStatusFragment()

        }
    }
}