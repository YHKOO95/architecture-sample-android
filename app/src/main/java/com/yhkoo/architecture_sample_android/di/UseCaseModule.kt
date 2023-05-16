package com.yhkoo.architecture_sample_android.di

import com.yhkoo.architecture_sample_android.domain.repository.Repository
import com.yhkoo.architecture_sample_android.domain.usecase.GetBeerInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetBeerInfoUseCase(repository: Repository): GetBeerInfoUseCase {
        return GetBeerInfoUseCase(repository)
    }
}