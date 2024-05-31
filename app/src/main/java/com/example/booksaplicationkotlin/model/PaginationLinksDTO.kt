package com.example.readx.models


import com.google.gson.annotations.SerializedName

data class PaginationLinksDTO(
    @SerializedName("current page")
    val currentPage: Int? = null,
    @SerializedName("links")
    val links: LinksDTO? = null,
    @SerializedName("per page")
    val perPage: Int? = null,
    @SerializedName("total")
    val total: Int? = null
)