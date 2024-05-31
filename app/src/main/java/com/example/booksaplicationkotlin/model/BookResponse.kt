package com.example.booksaplicationkotlin.model


import com.google.gson.annotations.SerializedName


data class BookResponse(
    @SerializedName("data")
    var `data`: List<Record>?,
    @SerializedName("msg")
    var msg: String?,
    @SerializedName("status")
    var status: Int?
)
data class RateResponse(
    @SerializedName("data")
    var `data`: String?,
    @SerializedName("msg")
    var msg: String?,
    @SerializedName("status")
    var status: Int?
)