package com.yhkoo.architecture_sample_android.data.model

import com.google.gson.annotations.SerializedName
import com.yhkoo.architecture_sample_android.data.base.BaseResponse
import com.yhkoo.architecture_sample_android.data.base.DataMapper
import com.yhkoo.architecture_sample_android.domain.model.Ingredients

data class IngredientsRes(
    @SerializedName("malts")
    val malt: List<MaltRes>? = null
) : BaseResponse {
    companion object : DataMapper<IngredientsRes, Ingredients> {
        override fun toDataModel(response: IngredientsRes): Ingredients {
            return Ingredients(
                malt = response.malt?.map { res ->
                    MaltRes.toDataModel(res)
                }
            )
        }
    }
}