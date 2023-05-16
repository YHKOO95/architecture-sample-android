package com.yhkoo.architecture_sample_android.domain.usecase

import com.yhkoo.architecture_sample_android.domain.model.BeerInfo
import com.yhkoo.architecture_sample_android.domain.repository.Repository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetBeerInfoUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<List<BeerInfo>> {
        return repository.getRandomBeer()
    }
}