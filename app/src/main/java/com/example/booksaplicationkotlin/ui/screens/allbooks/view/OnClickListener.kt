package com.example.booksaplicationkotlin.ui.screens.allbooks.view

import com.example.booksaplicationkotlin.model.Record

interface OnClickListener {
    fun onClickBookItem(record: Record)
}