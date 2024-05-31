package com.example.readx.models


import com.google.gson.annotations.SerializedName

data class LinksDTO(
    @SerializedName("first")
    val first: String? = null,
    @SerializedName("last")
    val last: String? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: Any? = null
)