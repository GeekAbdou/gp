package com.example.readx.models


import com.example.booksaplicationkotlin.model.Record
import com.google.gson.annotations.SerializedName

data class ResearchDataDTO(
    @SerializedName("pagination links")
    val paginationLinks: PaginationLinksDTO? = null,
    @SerializedName("records")
    val records: List<Record?>? = null
)