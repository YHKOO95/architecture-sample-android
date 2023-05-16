package com.yhkoo.architecture_sample_android.data.repositoryimpl

import com.yhkoo.architecture_sample_android.data.model.BeerInfoRes
import com.yhkoo.architecture_sample_android.data.network.service.PunkBeerService
import com.yhkoo.architecture_sample_android.domain.model.BeerInfo
import com.yhkoo.architecture_sample_android.domain.repository.Repository

class RepositoryImpl(
    private val punkBeerService: PunkBeerService
) : Repository {
    override suspend fun getRandomBeer(): List<BeerInfo> {
        return punkBeerService.getRandomBeer().map {
            BeerInfoRes.toDataModel(it)
        }
    }
}
