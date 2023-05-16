package com.yhkoo.architecture_sample_android.data.network.service

import com.yhkoo.architecture_sample_android.data.model.BeerInfoRes
import com.yhkoo.architecture_sample_android.data.network.utils.Response
import retrofit2.http.GET

interface PunkBeerService {

    @GET("/v2/beers/random")
    suspend fun getRandomBeer(): List<BeerInfoRes>
}