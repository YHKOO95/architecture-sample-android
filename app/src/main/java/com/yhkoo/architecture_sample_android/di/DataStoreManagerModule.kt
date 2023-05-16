package com.yhkoo.architecture_sample_android.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataStoreManagerModule {

//    @Singleton
//    @Provides
//    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
//        return DataStoreManager(context)
//    }
}