package com.yhkoo.architecture_sample_android.domain.repository

import com.yhkoo.architecture_sample_android.domain.model.BeerInfo
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getRandomBeer(): Flow<List<BeerInfo>>
}