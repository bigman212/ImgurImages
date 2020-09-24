package com.bigman212.imgur.gallery_image

import androidx.lifecycle.MutableLiveData
import com.bigman212.imgur.common.base.BaseViewModel
import com.bigman212.imgur.common.extensions.ioSubscribe
import com.bigman212.imgur.common.extensions.uiObserve
import com.bigman212.imgur.data.remote.pojo.GalleryComment
import com.bigman212.imgur.data.remote.pojo.ImgurGallery
import com.bigman212.imgur.gallery_image.domain.ImgurGalleryImageUseCase
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class ImgurGalleryImageViewModel @Inject constructor(
    private val useCase: ImgurGalleryImageUseCase
) : BaseViewModel() {

    sealed class State {
        object Loading : State()
        data class Content(val galleryData: ImgurGallery, val commentData: List<GalleryComment>) : State()
        data class Error(val error: Throwable) : State()

        companion object {
            fun initial() = Loading
        }
    }

    val viewState: MutableLiveData<State> = MutableLiveData(State.initial())

    fun fetchGalleryImage(hash: String) {
        Single.zip(
            useCase.fetchGalleryByHash(hash),
            useCase.fetchGalleryCommentByGalleryHash(hash)
        )
        { gallery, comments -> gallery to comments.take(20) }
            .ioSubscribe()
            .uiObserve()
            .subscribe(
                {
                    viewState.value = State.Content(it.first, it.second)
                },
                {
                    viewState.value = State.Error(it)
                    Timber.e(it)
                }
            )
            .disposeOnCleared()
    }
}
