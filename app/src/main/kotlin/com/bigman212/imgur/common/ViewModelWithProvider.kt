package com.bigman212.imgur.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * The ViewModelStoreOwner controls the scope of the ViewModel.
 * It may be overridden with a different ViewModelStoreOwner,
 * such as the host Activity or the parent fragment, in order to
 * scope the lifetime of the ViewModel to the lifetime of the
 * ViewModelStoreOwner that is passed in.
 */
inline fun <reified T : ViewModel> Fragment.viewModelWithProvider(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
    crossinline provider: () -> T
): Lazy<T> {
    return viewModels(ownerProducer) {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return provider.invoke() as T
            }
        }
    }
}

inline fun <T> Fragment.observe(liveData: LiveData<T>, crossinline block: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner) {
        block.invoke(it)
    }
}
