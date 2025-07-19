package com.yhkoo.architecture_sample_android.domain.usecase

import com.yhkoo.architecture_sample_android.domain.model.BeerInfo
import com.yhkoo.architecture_sample_android.domain.repository.Repository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GetBeerInfoUseCaseTest {

    @Mock
    private lateinit var repository: Repository

    private lateinit var useCase: GetBeerInfoUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        useCase = GetBeerInfoUseCase(repository)
    }

    @Test
    fun `invoke should return beer list from repository`() = runTest {
        // Given
        val expectedBeerList = listOf(
            BeerInfo.default.copy(
                id = 1,
                name = "Test Beer",
                tagline = "Test Tagline"
            )
        )
        whenever(repository.getRandomBeer()).thenReturn(flow { emit(expectedBeerList) })

        // When
        val result = useCase()

        // Then
        result.collect { beerList ->
            assertEquals(expectedBeerList, beerList)
        }
    }

    @Test
    fun `invoke should return empty list when repository returns empty`() = runTest {
        // Given
        val emptyList = emptyList<BeerInfo>()
        whenever(repository.getRandomBeer()).thenReturn(flow { emit(emptyList) })

        // When
        val result = useCase()

        // Then
        result.collect { beerList ->
            assertEquals(emptyList, beerList)
        }
    }
} 