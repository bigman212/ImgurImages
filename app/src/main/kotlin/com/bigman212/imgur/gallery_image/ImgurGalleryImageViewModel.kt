package com.bigman212.imgur.gallery_image

import androidx.lifecycle.MutableLiveData
import com.bigman212.imgur.common.BaseViewModel
import com.bigman212.imgur.common.extensions.ioSubscribe
import com.bigman212.imgur.common.extensions.uiObserve
import com.bigman212.imgur.remote.ImgurApi
import com.bigman212.imgur.remote.pojo.GalleryComment
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class ImgurGalleryImageViewModel @Inject constructor(
    private val api: ImgurApi
) : BaseViewModel() {

    sealed class State {
        object Loading : State()
        data class Content(val data: List<GalleryComment>) : State()
        data class Error(val error: Throwable) : State()

        companion object {
            fun initial() = Content(listOf())
        }
    }

    val viewState: MutableLiveData<State> = MutableLiveData(State.initial())

    fun fetchGalleryImage(hash: String) {
        api.fetchGalleryOrImageComments(hash)
            .doOnSubscribe { viewState.postValue(State.Loading) }
            .flatMapObservable { Observable.fromIterable(it.data) }
            .take(20)
            .toList()
            .ioSubscribe()
            .uiObserve()
            .subscribe(
                {
                    viewState.value = State.Content(it)
                },
                {
                    viewState.value = State.Error(it)
                    Timber.e(it)
                }
            )
            .disposeOnCleared()
    }
}
