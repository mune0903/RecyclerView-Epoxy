package com.github.mune0903.recyclerview_epoxy.data.remote.client


import com.github.mune0903.recyclerview_epoxy.data.remote.ARTICLE
import com.github.mune0903.recyclerview_epoxy.data.remote.model.Article
import io.reactivex.Observable
import retrofit2.http.GET

interface QiitaClient {

    @GET(ARTICLE)
    fun getArticle(): Observable<List<Article>>
}