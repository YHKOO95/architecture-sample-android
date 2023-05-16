package com.yhkoo.architecture_sample_android.data.repositoryimpl

import com.yhkoo.architecture_sample_android.data.model.BeerInfoRes
import com.yhkoo.architecture_sample_android.data.network.PunkBeerService
import com.yhkoo.architecture_sample_android.domain.model.BeerInfo
import com.yhkoo.architecture_sample_android.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(
    private val punkBeerService: PunkBeerService
) : Repository {
    override suspend fun getRandomBeer(): Flow<List<BeerInfo>> {
        return flow {
            emit(punkBeerService.getRandomBeer().map {
                BeerInfoRes.toDataModel(it)
            })
        }
    }
}
