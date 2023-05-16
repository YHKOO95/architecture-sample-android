package com.yhkoo.architecture_sample_android.domain.model

import com.yhkoo.architecture_sample_android.domain.base.BaseModel

data class BeerInfo(
    val id: Int,
    val name: String,
    val tagline: String,
    val firstBrewed: String,
    val description: String,
    val imageUrl: String,
    val abv: Double,
    val ibu: Int,
    val targetFg: Int,
    val targetOg: Int,
    val ebc: String,
    val srm: String,
    val ph: Double,
    val attenuationLevel: Double,
    val volume: Value,
    val boilVolume: Value,
    val method: Method,
    val ingredients: Ingredients,
    val foodPairing: List<String>,
    val brewersTips: String,
    val contributedBy: String
) : BaseModel