package com.homework.pets.data.remote.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class PaginationDto(
    @SerializedName("count_per_page")
    val countPerPage: Int,
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)