package com.travel.advisor.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.travel.advisor.viewmodel.factory.ListingViewModelFactory


/**
 * Gets the viewModel of the given type [T] on the Activity.
 *
 * @param factory the ViewModelProvider.Factory to create viewModels from.
 * */
inline fun <reified T : ViewModel> AppCompatActivity.viewModel(
        factory: ViewModelProvider.Factory = ListingViewModelFactory(resources)
) = ViewModelProviders.of(this, factory).get(T::class.java)
