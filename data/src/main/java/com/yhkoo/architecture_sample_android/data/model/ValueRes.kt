package com.yhkoo.architecture_sample_android.data.model

import com.google.gson.annotations.SerializedName
import com.yhkoo.architecture_sample_android.data.base.BaseResponse
import com.yhkoo.architecture_sample_android.data.base.DataMapper
import com.yhkoo.architecture_sample_android.domain.model.Value

open class ValueRes(
    @SerializedName("value")
    val value: Int? = 0,
    @SerializedName("unit")
    val unit: String? = ""
) : BaseResponse {
    companion object : DataMapper<ValueRes, Value> {
        override fun toDataModel(response: ValueRes): Value {
            return Value(
                value = response.value ?: 0,
                unit = response.unit ?: ""
            )
        }
    }

    override fun toString(): String {
        return "$value $unit"
    }
}