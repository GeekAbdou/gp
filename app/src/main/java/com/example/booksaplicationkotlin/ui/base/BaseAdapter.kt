package com.example.readx.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.booksaplicationkotlin.BR
import com.example.booksaplicationkotlin.ui.base.BaseDiffUtil


interface BaseInteractionListener

abstract class BaseAdapter<T>(private val listener: BaseInteractionListener?) :
    RecyclerView.Adapter<BaseViewHolder>() {

    var itemList = emptyList<T>()
    abstract val layoutId: Int

    open fun setItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(
            BaseDiffUtil(
                itemList, newItems, ::areItemsSame, ::areContentSame
            )
        )
        itemList = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = itemList.size

    open fun areItemsSame(oldItem: T, newItem: T) = oldItem?.equals(newItem) == true
    open fun areContentSame(oldPosition: T, newPosition: T) = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), layoutId, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = itemList[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.apply {
                    setVariable(BR.item, currentItem)
                    setVariable(BR.listener, listener)

                }
            }

        }
    }
}

class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)


object BRR {
    var _all = 0
    var item = 1
    var viewModel = 2
}
