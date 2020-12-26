package com.travel.advisor.viewmodel.factory

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.travel.advisor.repository.ListingsRepository
import com.travel.advisor.viewmodel.ListingViewModel

/**
 * [ViewModelProvider.Factory] to be able to have parameters in the [ViewModel]'s constructor.
 *
 * @param resources [Resources] to be used by the [ListingsRepository].
 * */
class ListingViewModelFactory(resources: Resources) : ViewModelProvider.Factory {

    private val listingsRepository = ListingsRepository(resources)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ListingViewModel(listingsRepository) as T
}