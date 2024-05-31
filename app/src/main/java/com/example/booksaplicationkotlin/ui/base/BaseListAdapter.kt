package com.example.readx.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.booksaplicationkotlin.BR

abstract class BaseListAdapter<T>(
    diffutils: DiffUtil.ItemCallback<T>,
) : ListAdapter<T, BaseListAdapter.BaseViewHolder<T>>(diffutils) {

    abstract val layoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), layoutId, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    open class BaseViewHolder<T>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: T) {
            binding.setVariable(BR.item, currentItem)

          /*  when (binding) {
                is RecommendationBooksBinding -> {
                    binding.recyclerViewBooks.adapter = ItemBooksAdapter()
                }


                is RecommendationGraduationProjectBinding -> {
                    binding.recyclerViewGraduationProject.adapter = ItemGraduationProjectsAdapter()
                }

                */

                /* is ItemTeamPlayersPositionsBinding -> {
                     binding.playersPositionRecycler.adapter = TeamPlayersAdapter()
                 }


                 is ItemStatisticsBlockBinding -> {
                     binding.recyclerBlock.adapter = SectionItemAdapter()
                 }

                 is ItemStandingBinding -> {
                     binding.formRecyclerView.adapter = StandingFormAdapter()
                 }*/
            }

        }
    }
