package com.yhkoo.architecture_sample_android.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

//    @Provides
//    @ViewModelScoped
//    fun provideGetKakaoUserIdUseCase(splashRepository: SplashRepository): GetKakaoUserIdUseCase {
//        return GetKakaoUserIdUseCase(splashRepository)
//    }
}