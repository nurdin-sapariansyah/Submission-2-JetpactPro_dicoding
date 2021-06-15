package com.nurdin.submission1jetpackpro.di

import android.content.Context
import com.nurdin.submission1jetpackpro.data.remote.RemoteDataSource
import com.nurdin.submission1jetpackpro.data.remote.ShowRepository

object Injection {
    fun provideRepository(context: Context): ShowRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return ShowRepository.getInstance(remoteDataSource)
    }
}