package com.yhkoo.architecture_sample_android.data.model

import com.google.gson.annotations.SerializedName
import com.yhkoo.architecture_sample_android.data.base.DataMapper
import com.yhkoo.architecture_sample_android.domain.model.MashTemp

data class MashTempRes(
    @SerializedName("duration")
    val duration: Int
) : ValueRes() {
    companion object : DataMapper<MashTempRes, MashTemp> {
        override fun toDataModel(response: MashTempRes): MashTemp {
            val item = ValueRes.toDataModel(response)
            return MashTemp(
                duration = response.duration
            ).apply {
                unit = item.unit
                value = item.value
            }
        }
    }
}