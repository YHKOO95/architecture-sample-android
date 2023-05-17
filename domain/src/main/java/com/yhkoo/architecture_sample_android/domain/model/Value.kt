package com.yhkoo.architecture_sample_android.domain.model

import com.yhkoo.architecture_sample_android.domain.base.BaseModel

open class Value(
    var value: Int = 0,
    var unit: String = ""
) : BaseModel {
    override fun toString(): String {
        return "$value $unit"
    }
}