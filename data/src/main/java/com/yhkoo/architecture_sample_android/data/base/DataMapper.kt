package com.yhkoo.architecture_sample_android.data.base

import com.yhkoo.architecture_sample_android.domain.base.BaseModel

interface DataMapper<in R : BaseResponse, out D : BaseModel> {
    fun toDataModel(response: R): D
}

