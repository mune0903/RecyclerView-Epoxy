package com.github.mune0903.recyclerview_epoxy.data.repository

import com.github.mune0903.recyclerview_epoxy.data.remote.model.Article
import io.reactivex.Observable

interface QiitaClientRepository {

    fun getArticle(): Observable<List<Article>>
}