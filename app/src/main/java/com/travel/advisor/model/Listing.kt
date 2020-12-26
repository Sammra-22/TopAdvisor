package com.travel.advisor.model

import com.squareup.moshi.JsonClass

/**
 * Represents a property listing
 * */
@JsonClass(generateAdapter = true)
data class Listing(
        val type: ListingType,
        val id: String,
        val name: String,
        val stars: Float,
        val reviews: Int,
        val municipality: String,
        val area: String,
        val established: String,
        val streetAddress: String,
        val thumbnail: String
)
