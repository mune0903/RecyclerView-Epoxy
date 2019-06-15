package com.github.mune0903.recyclerview_epoxy.ui

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.github.mune0903.recyclerview_epoxy.ItemArticleBindingModel_
import com.github.mune0903.recyclerview_epoxy.data.remote.model.Article
import com.github.mune0903.recyclerview_epoxy.util.extension.withModelsFrom
import com.github.mune0903.recyclerview_epoxy.util.horizontalCarousel

data class MainItemController(
    val articleList: List<Article> = emptyList()
) : TypedEpoxyController<MainItemController>() {

    override fun buildModels(data: MainItemController?) {
        data ?: return

        horizontalCarousel {
            id("carousel")
            numViewsToShowOnScreen(1.05f)
            padding(Carousel.Padding.dp(20, 18))
            withModelsFrom(data.articleList) {
                ItemArticleBindingModel_()
                    .id(it.id)
                    .article(it)
            }
        }
    }
}