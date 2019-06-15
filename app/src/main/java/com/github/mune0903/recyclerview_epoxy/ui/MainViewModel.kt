package com.github.mune0903.recyclerview_epoxy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mune0903.recyclerview_epoxy.data.remote.model.Article
import com.github.mune0903.recyclerview_epoxy.data.repository.QiitaClientRepository
import com.github.mune0903.recyclerview_epoxy.util.extension.observeOnMainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

class MainViewModel(
    val repository: QiitaClientRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _article = MutableLiveData<List<Article>>()
    val article: LiveData<List<Article>> = _article

    fun getArticle() {
       repository.getArticle()
            .observeOnMainThread()
            .subscribe({
                _article.value = it
            }, {
                Timber.e(it)
            }).addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}