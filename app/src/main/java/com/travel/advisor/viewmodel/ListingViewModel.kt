package com.travel.advisor.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travel.advisor.model.Listing
import com.travel.advisor.repository.ListingsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * [ViewModel] for [listings][Listing].
 *
 * @param listingsRepository [ListingsRepository] to pull the listings from.
 * */
class ListingViewModel(listingsRepository: ListingsRepository) : ViewModel() {
    val viewState: MutableLiveData<ViewState> = MutableLiveData(ViewState.Loading)

    init {
        loadListings(listingsRepository)
    }

    private fun loadListings(repository: ListingsRepository) {
        viewModelScope.launch {
            val listings = repository.getListings()
            delay(1000)
            viewState.value = if (listings.value == null) {
                ViewState.Error("Problem loading data")
            } else {
                ViewState.Loaded(repository.getListings().value)
            }
        }
    }
}