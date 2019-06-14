package com.github.mune0903.recyclerview_epoxy.data.repository

import com.github.mune0903.recyclerview_epoxy.data.remote.client.QiitaClient
import com.github.mune0903.recyclerview_epoxy.data.remote.model.Article
import com.github.mune0903.recyclerview_epoxy.util.extension.observeOnMainThread
import io.reactivex.Observable
import retrofit2.Retrofit

class QiitaRepositoryImpl(
    val retrofit: Retrofit
) : QiitaClientRepository {

    private val client by lazy { retrofit.create(QiitaClient::class.java) }

    override fun getArticle(): Observable<List<Article>> {
        return client.getArticle()
            .observeOnMainThread()
    }
}