package com.travel.advisor

import androidx.lifecycle.MutableLiveData
import org.junit.Assert.assertEquals
import org.junit.Test
import com.travel.advisor.model.Listing
import com.travel.advisor.repository.ListingsRepository
import com.travel.advisor.viewmodel.ListingViewModel
import com.travel.advisor.viewmodel.ViewState

/**
 * Tests for the [ListingViewModel]
 */
class ListingViewModelTest {

    class FaultyListingsRepository : ListingsRepository(null) {
        override fun getListings() = MutableLiveData<List<Listing>?>().apply { value = null }
    }

    @Test
    fun errorDataLoading() {
        val viewModel = ListingViewModel(FaultyListingsRepository())
        assertEquals(ViewState.Error("Problem loading data"), viewModel.viewState)
    }
}
