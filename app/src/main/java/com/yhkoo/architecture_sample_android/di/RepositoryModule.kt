package com.yhkoo.architecture_sample_android.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

//    @Singleton
//    @Provides
//    fun provideMainRepository(
//        mainApi: MainApi
//    ): MainRepository {
//        return MainRepositoryImpl(mainApi)
//    }
}