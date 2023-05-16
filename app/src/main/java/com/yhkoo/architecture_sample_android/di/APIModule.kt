package com.yhkoo.architecture_sample_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object APIModule {
//
//    @Singleton
//    @Provides
//    fun provideMainApi(retrofit: Retrofit): MainApi {
//        return retrofit.create(MainApi::class.java)
//    }
}