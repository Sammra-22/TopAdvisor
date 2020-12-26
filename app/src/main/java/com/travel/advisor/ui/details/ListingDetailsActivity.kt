package com.travel.advisor.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.travel.advisor.databinding.ListingDetailsBinding
import com.travel.advisor.extensions.viewModel
import com.travel.advisor.model.Listing
import com.travel.advisor.ui.BaseActivity
import com.travel.advisor.viewmodel.ListingViewModel
import com.travel.advisor.viewmodel.ViewState

class ListingDetailsActivity : BaseActivity() {
    private lateinit var binding: ListingDetailsBinding
    private val listingIndex: Int by lazy { intent?.getIntExtra(INDEX_KEY, 0) ?: 0 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListingDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
            }
            is ViewState.Loading -> {
                errorView.visibility = GONE
                progressView.visibility = VISIBLE
            }
            is ViewState.Loaded -> {
                errorView.visibility = GONE
                progressView.visibility = GONE
                if (state.data is List<*>) {
                    with(state.data[listingIndex]) {
                        if (this is Listing) {
                            fullname.text = name
                            address.text = streetAddress
                            Glide.with(baseContext)
                                    .load(thumbnail)
                                    .into(image)
                        }
                    }
                }

            }
        }
    }

    companion object {
        const val INDEX_KEY = "index"

        fun createIntent(context: Context, index: Int) = Intent(
                context, ListingDetailsActivity::class.java
        ).apply {
            putExtra(INDEX_KEY, index)
        }
    }
}
