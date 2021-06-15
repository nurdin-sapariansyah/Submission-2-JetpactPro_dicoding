package com.nurdin.submission1jetpackpro.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nurdin.submission1jetpackpro.data.remote.ShowRepository
import com.nurdin.submission1jetpackpro.di.Injection
import com.nurdin.submission1jetpackpro.viewModel.ContentViewModel
import com.nurdin.submission1jetpackpro.viewModel.DetailViewModel

class Factory private constructor(private val showRepository: ShowRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: Factory? = null

        fun getInstance(context: Context): Factory = instance ?: synchronized(this) {
            instance ?: Factory(Injection.provideRepository((context))).apply {
                instance = this
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ContentViewModel::class.java) -> {
                ContentViewModel(showRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(showRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}