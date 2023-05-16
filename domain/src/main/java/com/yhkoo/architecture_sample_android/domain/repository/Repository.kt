package com.yhkoo.architecture_sample_android.domain.repository

import com.yhkoo.architecture_sample_android.domain.model.BeerInfo
import retrofit2.Response

interface Repository {

    suspend fun getRandomBeer(): List<BeerInfo>

}