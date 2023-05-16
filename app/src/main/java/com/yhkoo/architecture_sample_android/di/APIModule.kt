package com.yhkoo.architecture_sample_android.di

import com.yhkoo.architecture_sample_android.data.network.PunkBeerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object APIModule {

    @Singleton
    @Provides
    fun providePunkBeerService(retrofit: Retrofit): PunkBeerService {
        return retrofit.create(PunkBeerService::class.java)
    }
}