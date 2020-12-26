package com.travel.advisor.ui.list

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.travel.advisor.databinding.ListingsActivityBinding
import com.travel.advisor.extensions.viewModel
import com.travel.advisor.model.Listing
import com.travel.advisor.ui.BaseActivity
import com.travel.advisor.viewmodel.ListingViewModel
import com.travel.advisor.viewmodel.ViewState

/**
 * Displays the list of listings
 * */
class ListingsActivity : BaseActivity() {
    private lateinit var binding: ListingsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListingsActivityBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel<ListingViewModel>().viewState.observe(this, Observer { render(it) })
    }

    override fun render(state: ViewState?) = with(binding) {
        when (state) {
            is ViewState.Error -> {
                errorView.apply {
                    visibility = VISIBLE
                    text = state.error
                }
                progressView.visibility = GONE
                propertyList.visibility = GONE
            }
            is ViewState.Loading -> {
                errorView.visibility = GONE
                progressView.visibility = VISIBLE
                propertyList.visibility = GONE
            }
            is ViewState.Loaded -> {
                errorView.visibility = GONE
                progressView.visibility = GONE
                propertyList.visibility = VISIBLE
                if (state.data is List<*>) {
                    propertyList.adapter = ListingAdapter(state.data.filterIsInstance<Listing>())
                    propertyList.addItemDecoration(DividerItemDecoration(
                            this@ListingsActivity,
                            DividerItemDecoration.VERTICAL
                    ))
                }
            }
        }
    }
}