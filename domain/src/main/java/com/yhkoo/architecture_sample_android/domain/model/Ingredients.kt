package com.yhkoo.architecture_sample_android.domain.model

import com.yhkoo.architecture_sample_android.domain.base.BaseModel

data class Ingredients(
    val malt: List<Malt>? = null
) : BaseModel