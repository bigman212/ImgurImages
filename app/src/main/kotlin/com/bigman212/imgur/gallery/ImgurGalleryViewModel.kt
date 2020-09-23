package com.bigman212.imgur.gallery

import androidx.lifecycle.MutableLiveData
import com.bigman212.imgur.common.BaseViewModel
import com.bigman212.imgur.common.extensions.ioSubscribe
import com.bigman212.imgur.common.extensions.uiObserve
import com.bigman212.imgur.gallery.domain.ImgurGalleryUseCase
import com.bigman212.imgur.remote.pojo.ImgurGallery
import com.bigman212.imgur.remote.pojo.ImgurImageInfo
import timber.log.Timber
import javax.inject.Inject

class ImgurGalleryViewModel @Inject constructor(
    private val useCase: ImgurGalleryUseCase
) : BaseViewModel() {

    sealed class State {
        object Loading : State()
        data class Content(val data: List<ImgurImageInfo>) : State()
        data class Error(val error: Throwable) : State()

        companion object {
            fun initial() = Content(listOf())
        }
    }

    val viewState: MutableLiveData<State> = MutableLiveData(State.initial())

    fun fetchImgurGalleryWithImages() {
        useCase.getTopImgurGallery()
            .doOnSubscribe { viewState.postValue(State.Loading) }
            .map { dataToViewContent(it.data) }
            .ioSubscribe()
            .uiObserve()
            .subscribe(
                {
                    viewState.value = State.Content(it)
                },
                {
                    Timber.e(it)
                    viewState.value = State.Error(it)
                })
            .disposeOnCleared()
    }

    private fun dataToViewContent(data: List<ImgurGallery>): List<ImgurImageInfo> {
        return data
            .asSequence()
            .map(ImgurGallery::images)
            .filter { it != null }
            .reduce { acc, list -> acc!! + list!! }!!
    }

}
