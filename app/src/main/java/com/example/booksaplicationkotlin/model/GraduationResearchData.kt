package com.example.booksaplicationkotlin.model


import com.google.gson.annotations.SerializedName
data class GraduationResearchData(
    @SerializedName("pagination links")
    var paginationLinks: PaginationLinks?,
    @SerializedName("records")
    var records: List<GraduationResearchRecord?>?
)