package com.example.portfoliodesign.presentation

sealed class ResourceUI<out T> {
    data class Success<out T>(val data: T) : ResourceUI<T>()
    data class Error(val message: String?) : ResourceUI<Nothing>()
    data object Loading : ResourceUI<Nothing>()
}