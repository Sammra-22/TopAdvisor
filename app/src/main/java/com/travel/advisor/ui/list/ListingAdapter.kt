package com.travel.advisor.ui.list


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.travel.advisor.databinding.ListingItemBinding
import com.travel.advisor.model.Listing

/**
 * Adapter for [listings][Listing]
 *
 * @param listings List of [listings][Listing] to be handled by the adapter.
 * */
class ListingAdapter(private val listings: List<Listing>) : RecyclerView.Adapter<ListingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = with(parent) {
        val binding = ListingItemBinding.inflate(LayoutInflater.from(context), this, false)
        ListingViewHolder(binding) {}
    }

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) = holder.bind(listings[position])

    override fun getItemCount() = listings.size
}
