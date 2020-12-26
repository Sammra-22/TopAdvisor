package com.travel.advisor.ui

import androidx.appcompat.app.AppCompatActivity
import com.travel.advisor.viewmodel.ViewState

/**
 * Base Activity for the app.
 * */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * Renders the [ViewState]
     *
     * @param state State to be rendered.
     * */
    abstract fun render(state: ViewState?)
}
