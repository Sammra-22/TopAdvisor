package com.travel.advisor.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * Moshi adapter for [ListingType].
 * */
class ListingTypeAdapter {
    @ToJson
    fun toJson(type: ListingType): String = type.type

    @FromJson
    fun fromJson(type: String): ListingType {
        return when (type) {
            "Museum" -> ListingType.MUSEUM
            "Palace" -> ListingType.PALACE
            "Landmark" -> ListingType.LANDMARK
            "Park" -> ListingType.PARK
            "Hotel" -> ListingType.HOTEL
            else -> throw NotImplementedError("Type not implemented")
        }
    }
}
