package com.travel.advisor.repository

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.travel.advisor.R
import com.travel.advisor.model.Listing
import com.travel.advisor.model.ListingResponse
import com.travel.advisor.model.ListingTypeAdapter

/**
 * Repository for the [Listing]s.
 *
 * @param resources Resources to fetch the raw json file from.
 * */
open class ListingsRepository(resources: Resources?) {
    private val moshi = Moshi.Builder()
            .add(ListingTypeAdapter())
            .add(KotlinJsonAdapterFactory())
            .build()

    private val jsonAdapter = moshi.adapter(ListingResponse::class.java)

    private val listings = MutableLiveData<List<Listing>>().apply {
        resources ?: return@apply

        val json = resources.openRawResource(R.raw.listings).bufferedReader().use { it.readText() }
        jsonAdapter.fromJson(json)?.let {
            value = it.listings
        }
    }

    open fun getListings(): LiveData<List<Listing>?> = listings
}
