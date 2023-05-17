package com.yhkoo.architecture_sample_android.data.model

import com.google.gson.annotations.SerializedName
import com.yhkoo.architecture_sample_android.data.base.DataMapper
import com.yhkoo.architecture_sample_android.domain.model.Fermentation

data class FermentationRes(
    @SerializedName("twist")
    val twist: String? = null
) : ValueRes() {
    companion object : DataMapper<FermentationRes, Fermentation> {
        override fun toDataModel(response: FermentationRes): Fermentation {
            val item = ValueRes.toDataModel(response)
            return Fermentation(
                twist = response.twist
            ).apply {
                unit = item.unit
                value = item.value
            }
        }
    }
}