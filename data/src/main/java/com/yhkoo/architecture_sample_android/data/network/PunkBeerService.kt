package com.yhkoo.architecture_sample_android.data.network

import com.yhkoo.architecture_sample_android.data.model.BeerInfoRes
import retrofit2.http.GET

interface PunkBeerService {

    @GET("/v2/beers/random")
    suspend fun getRandomBeer(): List<BeerInfoRes>
}