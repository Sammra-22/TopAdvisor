package com.travel.advisor.viewmodel

/**
 * Represents the possible states of a View.
 * */
sealed class ViewState {
    object Loading : ViewState()
    class Loaded(val `data`: Any?) : ViewState()
    class Error(val error: String) : ViewState()
}