package com.example.booksaplicationkotlin.ui.base

import androidx.recyclerview.widget.DiffUtil

open class BaseDiffUtil<T>(
    private val oldList: List<T>,
    private val newList: List<T>,
    private val checkIfSameItem: (oldItem: T, newItem: T) -> Boolean,
    private val checkIfSameContent: (oldItem: T, newItem: T) -> Boolean
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkIfSameItem(oldList[oldItemPosition], newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkIfSameContent(oldList[oldItemPosition], newList[newItemPosition])
    }
}