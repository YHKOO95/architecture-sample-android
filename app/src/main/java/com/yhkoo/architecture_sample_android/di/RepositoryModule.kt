package com.yhkoo.architecture_sample_android.di

import com.yhkoo.architecture_sample_android.data.network.PunkBeerService
import com.yhkoo.architecture_sample_android.data.repositoryimpl.RepositoryImpl
import com.yhkoo.architecture_sample_android.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        punkBeerService: PunkBeerService
    ): Repository {
        return RepositoryImpl(punkBeerService)
    }
}