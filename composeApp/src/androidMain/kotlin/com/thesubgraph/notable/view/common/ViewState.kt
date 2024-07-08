package com.thesubgraph.notable.view.common

import com.thesubgraph.notable.data.common.error.ErrorModel

sealed class ViewState<out T> {
    data object Initial : ViewState<Nothing>()
    data object Loading : ViewState<Nothing>()
    data class Success<T>(val result: T) : ViewState<T>()
    data class Error(val error: ErrorModel) : ViewState<Nothing>()

    val value: T? get() {
        return (this as? Success<T>)?.result
    }
}
