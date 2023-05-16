package com.yhkoo.architecture_sample_android.domain.model

import com.yhkoo.architecture_sample_android.domain.base.BaseModel

data class Method(
    val mashTemp: List<MashTemp>? = null,
    val fermentation: Fermentation? = null
) : BaseModel