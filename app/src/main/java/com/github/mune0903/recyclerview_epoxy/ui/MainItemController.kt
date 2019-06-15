package com.github.mune0903.recyclerview_epoxy.ui

import com.airbnb.epoxy.TypedEpoxyController
import com.github.mune0903.recyclerview_epoxy.data.remote.model.Article

data class MainItemController(
    val newsList: List<Article> = emptyList()
) : TypedEpoxyController<MainItemController>() {

    override fun buildModels(data: MainItemController?) {
        data ?: return


    }
}