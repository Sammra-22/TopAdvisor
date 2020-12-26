package com.travel.advisor.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.travel.advisor.R
import com.travel.advisor.databinding.ListingItemBinding
import com.travel.advisor.extensions.getFormattedString
import com.travel.advisor.extensions.getPluralString
import com.travel.advisor.model.Listing

/**
 * [ViewHolder] for each [Listing] on the list.
 * */
class ListingViewHolder(private val binding: ListingItemBinding, val onClick: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds the given listing
     *
     * @param listing [Listing] to be bound.
     * */
    fun bind(listing: Listing): Unit = with(binding) {
        title.text = listing.name
        address.text = listing.streetAddress
        localArea.text = getFormattedString(R.string.area_municipality, listing.area, listing.municipality)
        starCount.text = getFormattedString(R.string.stars_format, listing.stars)
        reviewCount.text = getPluralString(R.plurals.reviews_format, listing.reviews, listing.reviews)
        year.text = listing.established

        with(root) {
            Glide.with(context).load(listing.thumbnail).into(image)
            setOnClickListener { onClick(adapterPosition) }
        }
    }
}
